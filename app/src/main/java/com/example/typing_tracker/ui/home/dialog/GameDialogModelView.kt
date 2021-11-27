package com.example.typing_tracker.ui.home.dialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.typing_tracker.ui.base.BaseViewModel
import com.example.typing_tracker.util.Event

class GameDialogModelView: BaseViewModel() {


    private val _navigateToGame = MutableLiveData<Event<Boolean>>()
    val navigateToGame : LiveData<Event<Boolean>> = _navigateToGame

    private val _navigateToStatistics = MutableLiveData<Event<Boolean>>()
    val navigateToStatistics: LiveData<Event<Boolean>> = _navigateToStatistics



    fun onClickedAgain() {
        _navigateToGame.postValue(Event(true))
    }

    fun onClickedStatistics(){
        _navigateToStatistics.postValue(Event(true))
    }


}