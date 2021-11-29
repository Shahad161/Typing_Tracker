package com.example.typing_tracker.ui.statistics.speed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.typing_tracker.model.Repository
import com.example.typing_tracker.ui.base.BaseViewModel

class SpeedViewModel: BaseViewModel() {

    val charactersSpeedData = arrayOf(
        arrayOf("A", 100),
        arrayOf("B", 575),
        arrayOf("C", 523),
        arrayOf("D", 427),
        arrayOf("E", 399),
        arrayOf("F", 309),
        arrayOf("G", 208),
        arrayOf("H", 239),
        arrayOf("I", 205),
        arrayOf("J", 203),
        arrayOf("K", 182),
        arrayOf("L", 157),
        arrayOf("M", 109),
        arrayOf("N", 144),
        arrayOf("O", 143),
        arrayOf("P", 107),
        arrayOf("Q", 134),
        arrayOf("R", 118),
        arrayOf("S", 118),
        arrayOf("T", 117)
    )

//    val charactersSpeedData = MutableLiveData<Array<Double>>()

    init {
        observe(Repository.getWpm(), ::onSuccess, ::onFail)
        observe(Repository.getCharacterSpeed(), ::onCharacterSpeedSuccess, ::onFail)
    }

    private fun onCharacterSpeedSuccess(data: Array<Double>) {
//        charactersSpeedData.postValue(data)
    }

    private fun onSuccess(data: Array<out Any>) {
        _speedData.postValue(data)
    }

    private fun onFail(throwable: Throwable) {}


    private val _speedData = MutableLiveData<Array<out Any>>()
    val speedData: LiveData<Array<out Any>> = _speedData

}