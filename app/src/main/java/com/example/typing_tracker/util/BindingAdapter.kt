package com.example.typing_tracker.util

import android.view.View
import android.widget.*
import androidx.databinding.*


@BindingAdapter(value = ["app:selectedValue"])
fun selectedItem(view: Spinner, item: Difficulty?) {
    if (view.selectedItem?.toString() != item.toString()) {
        view.setSelection(view.getSelectedIndex(item))
    }
}


@InverseBindingAdapter(attribute = "selectedValue", event = "SpinnerOnItemSelected")
fun captureSelectedValue(view: Spinner): Difficulty {
    return view.selectedItem.toString().toDifficulty()
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
