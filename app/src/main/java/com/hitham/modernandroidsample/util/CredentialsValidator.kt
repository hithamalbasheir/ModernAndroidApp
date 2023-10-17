package com.hitham.modernandroidsample.util

class CredentialsValidator {
    fun validateUsername(username: String): Boolean {
        return username.length >= 8
    }

    fun validatePassword(password: String): Boolean {
        val hasUppercase = password.any { it.isUpperCase() }
        val hasLowercase = password.any { it.isLowerCase() }
        val hasDigit = password.any { it.isDigit() }
        return hasUppercase && hasLowercase && hasDigit
    }
}