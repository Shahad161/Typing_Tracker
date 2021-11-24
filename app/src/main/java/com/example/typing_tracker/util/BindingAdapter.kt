package com.example.typing_tracker.util

import android.R
import android.view.View
import android.widget.*
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener


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

@BindingAdapter(value = ["app:selectedValue"])
fun selectedItem(view: Spinner, item: String?) {
    if (view.selectedItem?.toString() != item) {
        view.setSelection(view.getSelectedIndex(item))
    }
}


@InverseBindingAdapter(attribute = "selectedValue", event = "SpinnerOnItemSelected")
fun captureSelectedValue(view: Spinner): String {
    return view.selectedItem.toString()
}


@BindingAdapter("SpinnerOnItemSelected")
fun setSelectedListener(view: Spinner, changeListener: InverseBindingListener) {
    view.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            changeListener.onChange()
        }
        override fun onNothingSelected(p0: AdapterView<*>?) {}
    }
}
