package com.hitham.modernandroidsample.util

import org.junit.Assert.*
import org.junit.Test

class CredentialsValidatorTest {

    private val validator = CredentialsValidator()

    @Test
    fun testValidateUsername() {
        assertTrue(validator.validateUsername("abcdefgh"))
        assertFalse(validator.validateUsername("abc"))
    }

    @Test
    fun testValidatePassword() {
        assertTrue(validator.validatePassword("Password1"))
        assertFalse(validator.validatePassword("password"))
        assertFalse(validator.validatePassword("PASSWORD"))
        assertFalse(validator.validatePassword("12345678"))
    }
}