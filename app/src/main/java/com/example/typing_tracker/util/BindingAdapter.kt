package com.example.typing_tracker.util

import android.R
import android.widget.*
import androidx.databinding.BindingAdapter


@BindingAdapter(value = ["app:entries"])
fun setEntries(view: Spinner, entries: Boolean?) {
    if (entries != null) {
        ArrayAdapter(
            view.context,
            R.layout.simple_spinner_dropdown_item, (Constants.difficulty.map { it })
        ).also {
                it.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                view.adapter = it
            }
    }
}
