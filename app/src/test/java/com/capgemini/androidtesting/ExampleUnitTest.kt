package com.capgemini.androidtesting

import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    val utility = MathUtility()

    @Ignore
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testMathAddition(){

        val result = utility.add(10, 20)

        assertEquals(30 , result)
    }

    @Test
    fun testMathMultiply(){
        val result = utility.multiply(0, 20)
        assertEquals("Multiplication with 0 should result with 0",10 , result)
    }
}