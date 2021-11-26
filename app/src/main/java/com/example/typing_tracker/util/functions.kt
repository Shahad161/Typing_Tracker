package com.example.typing_tracker.util

fun getTextColored(originalText: String,enterText: String, lastChar: Char) =
    originalText.replaceRange(
        enterText.lastIndex,
        enterText.length.addNextDistance(originalText,enterText),
        getPreviousCharColored(lastChar,enterText) + getNextCharColored(originalText,enterText.lastIndex)
    )

fun getNextCharColored(originalText: String, lastIndex: Int) =
    originalText.takeIf { it.lastIndex != lastIndex }?.let{
        it[lastIndex+1].getBackgroundColoredText(Constants.NEXT_CHAR_COLOR)
    } ?: ""

fun getPreviousCharColored(Char:Char, new:String) =
    if (Char.checkIfCorrectLastChar(new)) {
        Char.getColoredText(Constants.CORRECT_CHAR_COLOR)
    } else {
        Char.getColoredText(Constants.WRONG_CHAR_COLOR)
    }


fun getWordPerMinute(
    text: String?,
    totalTime: Long?
) = (text?.length ?: 0 ) / (totalTime ?:1L).toDouble()


fun getAccuracy(
    correctChar: Int,
    text: String?
) = (correctChar.toDouble() / (text?.length ?:1))*100
