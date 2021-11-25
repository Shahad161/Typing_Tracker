package com.example.typing_tracker.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.typing_tracker.model.Repository
import com.example.typing_tracker.model.domain.*
import com.example.typing_tracker.ui.base.BaseViewModel
import com.example.typing_tracker.util.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class HomeViewModel: BaseViewModel(){

    val enterText=MutableLiveData<String?>()
    val originalText = MutableLiveData<String>()

    val endGameEvent= MutableLiveData<Event<GameResult>>()
    private var isBegin =true

    private var lastDate :Long =1
    private val totalTime = MutableLiveData<Long>()
    private var correctChar =0
    private var incorrectChar =0
    private var level =Difficulty.NORMAL

    val startCounter =MutableLiveData(false)


    val checkInput :LiveData<String?> = MediatorLiveData<String?>().apply {
        addSource(originalText){
            this.postValue(it)
        }
        addSource(enterText){
            it?.let { newText ->
                onEnterDigit(newText){
                    this.postValue(it)
                }
            }
            setUpGame()
        }
    }

    private fun setUpGame() {
        if(isBegin){
            startCounter.postValue(true)
            lastDate= Date().time
            isBegin=false
        }
    }

    private fun onEnterDigit(newText:String , post :(String) -> Unit){
        originalText.value?.let { text ->
            Date().time.also{ time ->
                storeChar(newText.last(),getTime(time))
                updateStaticCharacter(newText,text[newText.lastIndex])
                updateLastTime(time)
                post(updatedText(text,newText,text[newText.lastIndex]))
                continueGame(text,newText)
            }
        }
    }

    private fun storeChar(lastChar: Char,time:Long) {
        Repository.insertCharacter(Character(0,"$lastChar",time.toDouble(), Date()))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    private fun continueGame(text: String, newText: String) {
        takeIf { text.length==newText.length }?.let {
            endGame()
        }
    }

    private fun updateStaticCharacter(newText: String, lastChar: Char) {
        if(lastChar.checkIfCorrectLastChar(newText)){
            correctChar++
        }else{
            incorrectChar++
        }
    }


    private fun updateLastTime(time: Long) {
        lastDate =time
    }

    private fun getTime(currentTime: Long) =if(isBegin) 0 else currentTime - lastDate

    private fun endGame() {
        with(getGameResult()){
            endGameEvent.postValue(Event(this))
            storeGame(this)
        }
    }

    private fun getGameResult() =
        GameResult(0,
            originalText.value?.length ?: 0,
            correctCharacters = correctChar,
            wrongCharacters = incorrectChar,
            wpm = 2.2,
            accuracy = 2.2,
            difficulty = level,
            date = Date()
        )

    private fun storeGame(gameResult: GameResult) {
        Repository.insertGameResult(gameResult)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }


    private fun updatedText(originalText :String,enteredText: String,lastChar: Char):String{
        return getTextColored(originalText,enteredText,lastChar)
    }

    fun getParagraph(level: Difficulty){
        this.level =level
        Repository.getParagraphByDifficulty(level)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess,::onFail)
    }

    private fun onSuccess(paragraph:String){
        originalText.postValue( paragraph)
    }

    private fun onFail(throwable: Throwable){
        Log.i(Constants.LOG_TAG,throwable.message.toString())
    }

}