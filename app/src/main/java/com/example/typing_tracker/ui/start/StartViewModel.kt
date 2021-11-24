package com.example.typing_tracker.ui.start

import androidx.lifecycle.*
import com.example.typing_tracker.ui.base.BaseViewModel
import com.example.typing_tracker.util.*

class StartViewModel: BaseViewModel() {

    val level = MutableLiveData<Difficulty>()

    private val _clickStart = MutableLiveData<Event<Difficulty?>>()
    val clickStart: LiveData<Event<Difficulty?>> = _clickStart


    fun onClickStartGame(){
        _clickStart.postValue(Event(level.value))
    }

}