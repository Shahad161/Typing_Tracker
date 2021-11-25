package com.example.typing_tracker.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.typing_tracker.model.Repository
import com.example.typing_tracker.model.domain.Character
import com.example.typing_tracker.ui.base.BaseViewModel
import com.example.typing_tracker.util.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class HomeViewModel: BaseViewModel(){

    val enterText=MutableLiveData<String?>()
    private val originalText = MutableLiveData<String>()

    val checkInput :LiveData<String?> = MediatorLiveData<String?>().apply {
        addSource(originalText){
            this.postValue(it)
        }
        addSource(enterText){
            it?.let { newText ->
                originalText.value?.let { text ->
                    storeChar(newText.last())
                    this.postValue(updatedText(text,newText,text[newText.lastIndex]))
                }
            }
        }
    }

    private fun storeChar(lastChar: Char) {
        Repository.insertCharacter(Character(0,"$lastChar",2.2, Date()))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    private fun updatedText(originalText :String,enteredText: String,lastChar: Char):String{
        return getTextColored(originalText,enteredText,lastChar)
    }

    fun getParagraph(level: Difficulty){
        Repository.getParagraphByDifficulty(level)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess,::onFail)
    }

    private fun onSuccess(paragraph:String){
        Log.i(Constants.LOG_TAG,paragraph)
        originalText.postValue( paragraph)
    }

    private fun onFail(throwable: Throwable){
        Log.i(Constants.LOG_TAG,throwable.message.toString())
    }

}