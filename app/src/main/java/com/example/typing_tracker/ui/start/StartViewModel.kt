package com.example.typing_tracker.ui.start

import androidx.lifecycle.MutableLiveData
import com.example.typing_tracker.ui.base.BaseViewModel
import com.example.typing_tracker.util.Event


class StartViewModel: BaseViewModel() {


    val gameCategory = MutableLiveData<String>()
    val gameConfigurationEvent = MutableLiveData<Event<String?>>()

    fun onClickStartGame(){
        gameConfigurationEvent.postValue(
            Event(gameCategory.value)
        )
    }
}