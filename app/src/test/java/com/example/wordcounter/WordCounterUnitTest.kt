package com.example.wordcounter

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class TextCalculatorTest {
    private lateinit var calculator: TextCalculator

    @Before
    fun setup() {
        calculator = TextCalculator()
    }

    @Test
    fun getWordsCount_emptyString_returnsZero() {
        val result = calculator.getWordsCount("")
        assertEquals(0, result)
    }

    @Test
    fun getWordsCount_singleWord_returnsOne() {
        val result = calculator.getWordsCount("hello")
        assertEquals(1, result)
    }

    @Test
    fun getWordsCount_multipleWords_returnsCorrectCount() {
        val result = calculator.getWordsCount("hello world test")
        assertEquals(3, result)
    }

    @Test
    fun getWordsCount_multipleSpaces_countsWordsCorrectly() {
        val result = calculator.getWordsCount("hello    world   test")
        assertEquals(3, result)
    }

    @Test
    fun getWordsCount_withNewlines_countsWordsCorrectly() {
        val result = calculator.getWordsCount("hello\nworld\ntest")
        assertEquals(3, result)
    }

    @Test
    fun getCharCount_emptyString_returnsZero() {
        val result = calculator.getCharCount("")
        assertEquals(0, result)
    }

    @Test
    fun getCharCount_singleWord_returnsCorrectCount() {
        val result = calculator.getCharCount("hello")
        assertEquals(5, result)
    }

    @Test
    fun getCharCount_withSpecialCharacters_countsCorrectly() {
        val result = calculator.getCharCount("hello!@#$%")
        assertEquals(10, result)
    }
}