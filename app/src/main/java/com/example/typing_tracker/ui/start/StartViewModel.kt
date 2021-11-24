package com.example.typing_tracker.ui.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.typing_tracker.ui.base.BaseViewModel
import com.example.typing_tracker.util.Event

class StartViewModel: BaseViewModel() {

    val level = MutableLiveData<String>()

    private val _clickStart = MutableLiveData<Event<String?>>()
    val clickStart: LiveData<Event<String?>> = _clickStart


    fun onClickStartGame(){
        _clickStart.postValue(Event(level.value))
    }

}