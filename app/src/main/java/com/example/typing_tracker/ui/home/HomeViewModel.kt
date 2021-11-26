package com.example.typing_tracker.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.typing_tracker.model.Repository
import com.example.typing_tracker.model.entities.*
import com.example.typing_tracker.ui.base.BaseViewModel
import com.example.typing_tracker.util.*
import io.reactivex.rxjava3.core.Observable
import java.util.*
import java.util.concurrent.TimeUnit

class HomeViewModel: BaseViewModel(){

    private val currentTime = Observable.interval(1,TimeUnit.SECONDS)
    private var isBegin = true
    private var totalTime: Long? = null
    private var lastDate: Long? = null
    private var correctChar = 0
    private var incorrectChar = 0
    private var level : Difficulty? = null

    val enterText=MutableLiveData<String?>()
    val originalText = MutableLiveData<String>()
    val endGameEvent= MutableLiveData<Event<GameResult>>()

    private val _startCounter =MutableLiveData(false)
    val startCounter : LiveData<Boolean> = _startCounter

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
            _startCounter.postValue(true)
            lastDate= Date().time
            currentTime.subscribe{
                totalTime =it
            }
            isBegin=false
        }
    }

    private fun onEnterDigit(newText:String , post :(String) -> Unit){
        originalText.value?.let { text ->
            Date().time.also{ currentTime ->
                updateStatistics(newText, text , currentTime)
                updateLastTime(currentTime)
                post(updatedText(text,newText,text[newText.lastIndex]))
                continueGame(text,newText)
            }
        }
    }

    private fun updateStatistics(newText:String, text: String, currentTime: Long){
        with(getSpeed(currentTime).toDouble()) {
            if(text[newText.lastIndex].checkIfCorrectLastChar(newText)){
                storeCorrectChar(newText.last(),this)
                correctChar ++
            }else {
                storeInCorrectChar(newText.last(),this)
                incorrectChar ++
            }
        }
    }

    private fun getSpeed(currentTime: Long) =if(isBegin) 0 else currentTime - (lastDate ?: 0L)

    private fun storeCorrectChar(lastChar: Char,speed:Double) {
        observe(Repository.insertCharacter(getCharacter(lastChar,speed,true)))
    }

    private fun storeInCorrectChar(lastChar: Char,speed: Double) {
        observe(Repository.insertCharacter(getCharacter(lastChar,speed,false)))
    }

    //must pass isCorrect value when change schema
    private fun getCharacter(char: Char ,speed: Double ,isCorrect: Boolean) =
        Character(
            id= 0, // delete this line
            character = "$char",
            isCorrect = isCorrect,
            speed = speed,
            entryDate = Date()
        )

    private fun updateLastTime(time: Long) {
        lastDate =time
    }

    private fun updatedText(originalText :String,enteredText: String,lastChar: Char):String{
        return getTextColored(originalText,enteredText,lastChar)
    }

    private fun continueGame(text: String, newText: String) {
        takeIf { text.length==newText.length }?.let {
            endGame()
        }
    }

    private fun endGame() {
        with(getGameResult()){
            endGameEvent.postValue(Event(this))
            storeGame(this)
        }
    }

    private fun getGameResult() =
        GameResult(0,
            originalText.value?.length ?: 0 ,
            correctCharacters = correctChar ,
            wrongCharacters = incorrectChar ,
            wpm = getWordPerMinute(originalText.value,totalTime) ,
            accuracy = getAccuracy(correctChar,originalText.value) ,
            difficulty = level ?: Difficulty.EASY ,
            date = Date()
        )

    private fun storeGame(gameResult: GameResult) {
        observe(Repository.insertGameResult(gameResult))
    }


    fun getParagraph(level: Difficulty){
        this.level =level
        observe(Repository.getParagraphByDifficulty(level),::onSuccess,::onFail)
    }

    private fun onSuccess(paragraph:String){
        originalText.postValue( paragraph)
    }

    private fun onFail(throwable: Throwable){
        Log.i(Constants.LOG_TAG,throwable.message.toString())
    }

}