package com.example.typing_tracker.ui.start

import androidx.lifecycle.*
import com.example.typing_tracker.ui.base.BaseViewModel
import com.example.typing_tracker.util.*



class StartViewModel: BaseViewModel() {

    private val _difficulty = MutableLiveData<Event<Difficulty>>()
    val difficulty : LiveData<Event<Difficulty>>
    get() = _difficulty

    fun onClickStartGame(difficulty: String){
        _difficulty.postValue(Event(enumValueOf(difficulty.uppercase())))
    }


}