package com.example.typing_tracker.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.typing_tracker.model.Repository
import com.example.typing_tracker.ui.base.BaseViewModel
import com.example.typing_tracker.util.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel: BaseViewModel(){

    private val _paragraph = MutableLiveData<String>()
    val paragraph: LiveData<String> = _paragraph

    fun getParagraph(diffuctilly: Difficulty){

        Repository.getParagraphByDifficulty(diffuctilly)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess,::onFail)
    }

    private fun onSuccess(paragraph:String){
        Log.i(Constants.LOG_TAG,paragraph)
        _paragraph.postValue(paragraph)
    }

    private fun onFail(throwable: Throwable){
        Log.i(Constants.LOG_TAG,throwable.message.toString())
    }

}