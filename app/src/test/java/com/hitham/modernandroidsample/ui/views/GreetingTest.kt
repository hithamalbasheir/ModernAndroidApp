package com.hitham.modernandroidsample.ui.views

import androidx.compose.runtime.Composable
import org.junit.Assert.assertEquals
import org.junit.Test

class GreetingTest {
    @Test
    @Composable
    fun testMorningGreeting() {
        val greeting = greetingMessage(10)
        assertEquals("Good Morning", greeting)
    }

    @Test
    @Composable
    fun testAfternoonGreeting() {
        val greeting = greetingMessage(14)
        assertEquals("Good Afternoon", greeting)
    }

    @Test
    @Composable
    fun testEveningGreeting() {
        val greeting = greetingMessage(20)
        assertEquals("Good Evening", greeting)
    }
}