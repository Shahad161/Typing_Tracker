package com.example.typing_tracker.ui.statistics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.typing_tracker.ui.base.BaseViewModel

class StatisticsViewModel: BaseViewModel() {


    private val _clickBackButton = MutableLiveData<Boolean>()
    val clickBackButton: LiveData<Boolean> = _clickBackButton


    fun onClickBackButton(){
        _clickBackButton.postValue(true)
    }

}