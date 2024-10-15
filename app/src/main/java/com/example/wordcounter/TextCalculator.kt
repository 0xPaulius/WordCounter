package com.example.wordcounter

class TextCalculator {
    fun getWordsCount(text: String): Int {
        return text.split(Regex("\\s+")).filter { it.isNotEmpty() }.size
    }

    fun getCharCount(text: String): Int {
        return text.replace("\\s".toRegex(), "").length
    }
}