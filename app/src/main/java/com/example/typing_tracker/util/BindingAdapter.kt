package com.example.typing_tracker.util

import android.text.Html
import android.view.View
import android.widget.*
import androidx.databinding.*
import com.example.typing_tracker.ui.home.CharListener


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


@BindingAdapter(value = ["app:updateParagraph","app:originalText","app:onCharEntered"])
fun whenCharEntered(view :TextView, enterText :String?, originalText:String?, listener:CharListener){
    enterText?.takeIf { it.isNotEmpty() }?.let {
        view.text = getNewText(originalText, it)
        originalText?.get(it.lastIndex)?.let { it1 -> enterChar(it1,enterText,listener) }
    }
}

fun getNewText(originalText:String?, enterText: String ) =
    Html.fromHtml(
        originalText?.replaceRange(
            enterText.lastIndex,
            enterText.length,
            getFormattedText(originalText,enterText)
        ), Html.FROM_HTML_MODE_LEGACY)

fun getFormattedText(old:String, new:String): String{
    with(old[new.lastIndex]) {
        return if (this.checkIfCorrectLastChar(new)) {
            this.getHtmlFormatText("green")
        } else {
            this.getHtmlFormatText("red")
        }
    }
}

fun enterChar(lastChar: Char, new:String , charListener : CharListener ){
    charListener.onEnterChar("$lastChar",lastChar.checkIfCorrectLastChar(new))
}

fun Char.checkIfCorrectLastChar(newText: String) = this == newText.last()