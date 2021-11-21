package com.example.typing_tracker.ui.base

import androidx.lifecycle.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*

abstract class BaseViewModel: ViewModel() {

    fun <T> collectResponse(flow: Flow<T?>, function: (T?) -> Unit) {
        viewModelScope.launch {
            flow.flowOn(Dispatchers.IO)
                .collect { state ->
                    function(state)
                }
        }
    }

}