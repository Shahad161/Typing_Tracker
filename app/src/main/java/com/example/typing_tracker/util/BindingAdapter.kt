package com.example.typing_tracker.util

import android.R
import android.widget.*
import androidx.databinding.BindingAdapter


@BindingAdapter(value = ["app:entries"])
fun setEntries(view: Spinner, entries: List<String>?) {
    if (entries != null) {
        ArrayAdapter(
            view.context,
            R.layout.simple_spinner_dropdown_item, (entries.map { it })
        ).also {
                it.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                view.adapter = it
            }
    }
}
