package com.example.typing_tracker.util

import android.text.Html
import android.util.Log
import android.view.KeyEvent
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

@BindingAdapter(value = ["app:setParagraph"])
fun setParagraph(view :TextView , paragraph:String?){
    paragraph?.let {
        view.text =Html.fromHtml(it,Html.FROM_HTML_MODE_LEGACY)
    }
}


@BindingAdapter(value = ["app:updateParagraph","app:originalText"])
fun updateParagraph(view :TextView, enterText :String?, originalText:String?){
    enterText?.takeIf { it.isNotEmpty() }?.let {
            view.text= Html.fromHtml(
                originalText?.replaceRange(
                    enterText.lastIndex,
                    enterText.length,
                    getFormatedText(originalText,it)
                ),
                Html.FROM_HTML_MODE_LEGACY
            )
        }
}

fun getFormatedText(old:String, new:String):String{
    return if(old[new.lastIndex] == new.last()){
        "<font color='green'>${old[new.lastIndex]}</font>"
    }else
        "<font color='red'>${old[new.lastIndex]}</font>"
}
