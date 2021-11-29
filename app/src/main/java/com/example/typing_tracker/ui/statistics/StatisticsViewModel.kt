package com.example.typing_tracker.ui.statistics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.typing_tracker.ui.base.BaseViewModel
import com.example.typing_tracker.util.*


class StatisticsViewModel: BaseViewModel() {


    private val _clickBackButton = MutableLiveData<Event<Boolean>>()
    val clickBackButton: LiveData<Event<Boolean>> = _clickBackButton


    fun onClickBackButton(){
        _clickBackButton.postValue(Event(true))
    }

}