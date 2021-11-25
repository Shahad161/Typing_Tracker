package com.example.typing_tracker.util

import android.view.View
import android.widget.Spinner
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import androidx.navigation.Navigation


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
    this.observe(owner, EventObserver{ it ->
        function(it)
    })
}

fun String.toDifficulty() :Difficulty{
    return when(this){
        "Hard" -> Difficulty.HARD
        "Easy" -> Difficulty.EASY
        else -> Difficulty.NORMAL
    }
}

fun Char.getHtmlFormatText(color: String) =  "<font color='$color'>$this</font>"
fun Char.checkIfCorrectLastChar(newText: String) = this == newText.last()

