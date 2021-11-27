package com.example.typing_tracker.ui.home.dialog

import android.util.Log
import androidx.lifecycle.*
import com.example.typing_tracker.model.Repository
import com.example.typing_tracker.model.entities.GameResult
import com.example.typing_tracker.ui.base.BaseViewModel
import com.example.typing_tracker.util.Event

class GameDialogModelView: BaseViewModel() {


    private val _navigateToGame = MutableLiveData<Event<Boolean>>()
    val navigateToGame : LiveData<Event<Boolean>> = _navigateToGame

    private val _navigateToStatistics = MutableLiveData<Event<Boolean>>()
    val navigateToStatistics: LiveData<Event<Boolean>> = _navigateToStatistics



    fun getLastGameResult(){
        observe(Repository.getLastGamesResults(),::onSuccess,::onFail)
    }


    private fun onSuccess(paragraph: GameResult){
        Log.i("kkk",paragraph.toString())
    }

    private fun onFail(throwable: Throwable){
        Log.i("kkk",throwable.message.toString())
    }



    fun onClickedAgain() {
        _navigateToGame.postValue(Event(true))
    }

    fun onClickedStatistics(){
        _navigateToStatistics.postValue(Event(true))
    }


}