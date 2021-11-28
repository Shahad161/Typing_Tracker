package com.example.typing_tracker.ui.statistics.speed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.typing_tracker.model.Repository
import com.example.typing_tracker.ui.base.BaseViewModel

class SpeedViewModel: BaseViewModel() {

    val charactersSpeedData = MutableLiveData<Array<Double>>()

    init {
        observe(Repository.getWpm(), ::onSuccess, ::onFail)
        observe(Repository.getCharacterSpeed(), ::onCharacterSpeedSuccess, ::onFail)
    }

    private fun onCharacterSpeedSuccess(data: Array<Double>) {
        Log.v("kkk", data.toString())
        charactersSpeedData.postValue(data)
    }

    private fun onSuccess(data: Array<out Any>) {
        _speedData.postValue(data)
    }

    private fun onFail(throwable: Throwable) {}


    private val _speedData = MutableLiveData<Array<out Any>>()
    val speedData: LiveData<Array<out Any>> = _speedData

}