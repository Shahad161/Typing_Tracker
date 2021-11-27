package com.example.typing_tracker.util

import android.view.View
import android.widget.Spinner
import androidx.lifecycle.*
import androidx.navigation.*
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable


fun View.goToFragment(navDir: NavDirections) {
    Navigation.findNavController(this).navigate(navDir)
}


fun <T> Spinner.getSelectedIndex(item: T?): Int {
    for (index in 0 until adapter.count) {
        if (adapter.getItem(index) == item) {
            return index
        }
    }
    return -1
}

fun <T> LiveData<Event<T>>.observeEvent(owner: LifecycleOwner, function:(T) ->Unit){
    this.observe(owner, EventObserver{
        function(it)
    })
}

fun String.toDifficulty() :Difficulty = enumValueOf(this.uppercase())


fun Char.getColoredText(color: String) =  "<font color='$color'>$this</font>"

fun Char.getBackgroundColoredText(color: String) =  "<span style='background-color:$color;'>$this</span>"

fun Char.checkIfCorrectLastChar(newText: String) = this == newText.last()

fun Int.addNextDistance(originalText: String , enterText: String) =
    this + if(originalText.length == enterText.length) 0 else 1

fun Disposable.add(disposable: CompositeDisposable) {
    disposable.add(this)
}