package com.yuyan.imemodule.utils

fun segmentText(text: String): List<String> {
    if (text.isBlank()) return emptyList()
    val result = mutableListOf<String>()
    val boundaries = java.text.BreakIterator.getWordInstance(java.util.Locale.CHINA)
    boundaries.setText(text)
    var start = boundaries.first()
    var end = boundaries.next()
    while (end != java.text.BreakIterator.DONE) {
        val token = text.substring(start, end)
        if (!token.isBlank()) result.add(token)
        start = end
        end = boundaries.next()
    }
    return result
}
