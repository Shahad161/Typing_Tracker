package com.example.typing_tracker.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.typing_tracker.ui.base.BaseViewModel
import com.example.typing_tracker.util.*

class HomeViewModel: BaseViewModel(),CharListener{

    private val _paragraph = MutableLiveData<String>()
    val paragraph: LiveData<String> = _paragraph


    val enterText=MutableLiveData<String?>()


    fun getParagraph(diffuctilly: Difficulty){
        _paragraph.postValue("this is test paragraph this is test paragraph this is test paragraph this is test paragraph this is test paragraph ")
//        Repository.getParagraphByDifficulty(diffuctilly)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(::onSuccess,::onFail)
    }

    private fun onSuccess(paragraph:String){
        Log.i(Constants.LOG_TAG,paragraph)
        _paragraph.postValue(paragraph)
    }

    private fun onFail(throwable: Throwable){
        Log.i(Constants.LOG_TAG,throwable.message.toString())
    }

    override fun onEnterChar(char: String, isCorrect: Boolean) {
        Log.i("HHHH","the $char is enter and is it $isCorrect")
    }
}