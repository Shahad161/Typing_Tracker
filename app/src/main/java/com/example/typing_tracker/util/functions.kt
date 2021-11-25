package com.example.typing_tracker.util

fun getTextColored(originalText: String,enterText: String, lastChar: Char) =
    originalText.replaceRange(
        enterText.lastIndex,
        enterText.length,
        getFormattedText(lastChar,enterText)
    )

fun getFormattedText(Char:Char, new:String) =
    if (Char.checkIfCorrectLastChar(new)) {
        Char.getHtmlFormatText("green")
    } else {
        Char.getHtmlFormatText("red")
    }
