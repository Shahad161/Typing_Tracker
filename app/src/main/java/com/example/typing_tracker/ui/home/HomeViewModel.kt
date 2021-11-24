package com.example.typing_tracker.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.typing_tracker.model.Repository
import com.example.typing_tracker.ui.base.BaseViewModel
import com.example.typing_tracker.util.Constants
import com.example.typing_tracker.util.Difficulty
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel: BaseViewModel(){

    private val _paragraph = MutableLiveData<String>()
    val paragraph: LiveData<String> = _paragraph

    fun getParagraph(diffuctilly: Difficulty){

        Repository.getParagraphByDifficulty(diffuctilly)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess,::onFail)


    }

    private fun onSuccess(paragraph:String){
        _paragraph.postValue(paragraph)
    }

    private fun onFail(throwable: Throwable){
        Log.i(Constants.LOG_TAG,throwable.message.toString())
    }

}