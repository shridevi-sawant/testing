package com.capgemini.androidtesting

import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    // declare test rule

    @get:Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testLayout(){
       val scenario = rule.scenario

        scenario.onActivity { activity ->
            val tv = activity.findViewById<TextView>(R.id.tv)
            Assert.assertNotNull("Textview should be available",tv)

            val btn = activity.findViewById<Button>(R.id.button)
            Assert.assertNotNull("Button should be available",btn)

            val edText = activity.findViewById<EditText>(R.id.nameE)
            Assert.assertNotNull("EditText to enter name Not found",edText)

            val initialText = edText.text.toString()
            Assert.assertEquals("", initialText)

            val tvText = tv.text
            Assert.assertEquals("Hello World!", tvText)

            val btnEnabled = btn.isEnabled
            Assert.assertTrue(btnEnabled)

            edText.setText("demo")
            btn.callOnClick()

            val updatedText = tv.text
            Assert.assertEquals("Hello demo", updatedText)

        }
    }


}