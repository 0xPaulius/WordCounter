package com.example.wordcounter

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.containsString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun testWordCount() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.editTextInput))
            .perform(typeText("hello world test"), closeSoftKeyboard())

        onView(withId(R.id.spinnerOption)).perform(click())
        onView(withText(R.string.option_words)).perform(click())

        onView(withId(R.id.buttonCalculate)).perform(click())

        onView(withId(R.id.textViewResult))
            .check(matches(withText(containsString("3"))))
    }

    @Test
    fun testCharacterCount() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.editTextInput))
            .perform(typeText("hello world"), closeSoftKeyboard())

        onView(withId(R.id.spinnerOption)).perform(click())
        onView(withText(R.string.option_characters)).perform(click())

        onView(withId(R.id.buttonCalculate)).perform(click())

        onView(withId(R.id.textViewResult))
            .check(matches(withText(containsString("10"))))
    }


}