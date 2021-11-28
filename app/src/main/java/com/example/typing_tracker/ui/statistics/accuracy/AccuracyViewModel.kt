package com.example.typing_tracker.ui.statistics.accuracy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.typing_tracker.model.Repository
import com.example.typing_tracker.ui.base.BaseViewModel

class AccuracyViewModel : BaseViewModel() {

    val charactersAccuracyData = arrayOf(
        arrayOf("A", 1000),
        arrayOf("B", 575),
        arrayOf("C", 523),
        arrayOf("D", 427),
        arrayOf("E", 399),
        arrayOf("F", 309),
        arrayOf("G", 278),
        arrayOf("H", 239),
        arrayOf("I", 235),
        arrayOf("J", 203),
        arrayOf("K", 182),
        arrayOf("L", 157),
        arrayOf("M", 149),
        arrayOf("N", 144),
        arrayOf("O", 143),
        arrayOf("P", 137),
        arrayOf("Q", 134),
        arrayOf("R", 118),
        arrayOf("S", 118),
        arrayOf("T", 117)
    )

    init {
        observe(Repository.getAccuracy(), ::onSuccess, ::onError)
    }

    private fun onSuccess(data: Array<Double>) {
        _accuracyData.postValue(data)
    }

    private fun onError(throwable: Throwable) {}

    private val _accuracyData = MutableLiveData<Array<out Any>>()
    val accuracyData: LiveData<Array<out Any>> = _accuracyData
}