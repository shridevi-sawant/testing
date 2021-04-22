package com.capgemini.androidtesting

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

class MainActivityEspresso {

    @get:Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

    @Ignore
    @Test
    fun testLayout(){

        Espresso.onView(withId(R.id.button))
            .check(ViewAssertions.matches(withText("Click Me")))

        Espresso.onView(withText("Hello World!"))
            .check(ViewAssertions.matches(withId(R.id.tv)))

        Espresso.onView(withId(R.id.nameE))
            .perform(ViewActions.typeText("Shridevi"))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(withId(R.id.button))
            .perform(ViewActions.click())

       // Espresso.pressBack()

        Espresso.onView(withId(R.id.tv))
            .check(ViewAssertions.matches(withText("Hello Shridevi")))

        Espresso.onView(withId(R.id.nameE))
            .check(ViewAssertions.matches(withText("")))

        Espresso.onView(withId(R.id.button))
            .check(ViewAssertions.matches(allOf(withText("Done"),
                not(isEnabled()))))

    }

    @Test
    fun testLaunchNextActivity(){

        Espresso.onView(withId(R.id.nameE))
            .perform(ViewActions.typeText("Shridevi"))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(withId(R.id.button))
            .perform(ViewActions.click())

        Espresso.onView(withId(R.id.dispT))
            .check(ViewAssertions.matches(withText("Shridevi")))

    }
}