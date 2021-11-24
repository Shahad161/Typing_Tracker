package com.example.typing_tracker.ui.start

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.typing_tracker.ui.base.BaseViewModel
import com.example.typing_tracker.util.Constants
import com.example.typing_tracker.util.Event

class StartViewModel: BaseViewModel() {

    val levels = Constants.difficulty

    val level = MutableLiveData<String>()

    private val _clickStart = MutableLiveData<Event<String?>>()
    val clickStart: LiveData<Event<String?>> = _clickStart


    fun onClickStartGame(){
        _clickStart.postValue(Event(level.value))
    }
}