package com.hitham.modernandroidsample.ui.views

import com.hitham.modernandroidsample.util.CredentialsValidator
import org.junit.Assert.*
import org.junit.Test

class LoginScreenTest {

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