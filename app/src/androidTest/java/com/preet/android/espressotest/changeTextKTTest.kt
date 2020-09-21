package com.preet.android.espressotest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class changeTextKTTest {

    @Rule
    var mActivityRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun ensureTextChangesWork() {
        onView(withId(R.id.inputField))
            .perform(ViewActions.typeText("HELLO"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.changeText)).perform(ViewActions.click())

        onView(withId(R.id.inputField))
            .check(ViewAssertions.matches(ViewMatchers.withText("ChangeDone")))
    }

    @Test
    fun changeText_verifyNewView() {
        onView(withId(R.id.inputField)).perform(
            ViewActions.typeText("NewText"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.switchActivity)).perform(ViewActions.click())

        onView(withId(R.id.resultView))
            .check(ViewAssertions.matches(ViewMatchers.withText("NewText")))
    }
}