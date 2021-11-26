package com.example.typing_tracker.ui.base

import androidx.lifecycle.*
import com.example.typing_tracker.util.add
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BaseViewModel: ViewModel() {

    private val disposable= CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

    fun <T>observe(
        observable: Single<T>,
        onSuccess:(T)->Unit,
        onError:(Throwable)-> Unit
    ){
        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onSuccess,onError).add(disposable)
    }

    fun observe(
        observable: Completable,
    ){
        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe().add(disposable)
    }

}

