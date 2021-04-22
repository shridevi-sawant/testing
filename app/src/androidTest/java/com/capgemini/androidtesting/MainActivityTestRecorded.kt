package com.capgemini.androidtesting


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTestRecorded {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityTestRecorded() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.nameE),
                isDisplayed()
            )
        )
        appCompatEditText.perform(typeText("demo"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.nameE), withText("demo"),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(click())

        val materialButton = onView(
            allOf(
                withId(R.id.button), withText("Click Me"),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        pressBack()




        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.nameE), withText("demo"),

                isDisplayed()
            )
        )
        appCompatEditText4.perform(replaceText("test"))

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.nameE), withText("test"),

                isDisplayed()
            )
        )
        appCompatEditText5.perform(closeSoftKeyboard())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
