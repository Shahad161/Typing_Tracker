package com.example.typing_tracker.ui.start

import androidx.lifecycle.*
import com.example.typing_tracker.ui.base.BaseViewModel
import com.example.typing_tracker.util.*

class StartViewModel: BaseViewModel() {

    val difficulity = MutableLiveData<Difficulty>()

    private val _clickStart = MutableLiveData<Event<Difficulty?>>()
    val clickStart: LiveData<Event<Difficulty?>> = _clickStart

    private val _clickStatistic = MutableLiveData<Event<Boolean>>()
    val clickStatistic: LiveData<Event<Boolean>> = _clickStatistic

    fun onClickStatistic(){
        _clickStatistic.postValue(Event(true))
    }
    fun onClickStartGame(){
        _clickStart.postValue(Event(difficulity.value))
    }

}