package com.toluleke.mktfy.core

import java.lang.Exception
import java.time.YearMonth
import java.time.format.DateTimeFormatter

object Validator {

    fun isValidPassword(password: String) = password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\^$*.\\[\\]{}()?\"!@#%&/\\\\,><':;|_~`])[a-zA-Z\\d^\$*.\\[\\]{}()?\"!@#%&/\\\\,><':;|_~`]{8,}$".toRegex())
    fun isValidUsername(username: String) = username.matches("^(?:[a-zA-Z0-9]){5,20}$".toRegex())

    fun isValidDate(date: String): Boolean {
        return try {
            YearMonth.parse(date, DateTimeFormatter.ofPattern("MMyy")).isAfter(YearMonth.now()) ||
                    YearMonth.parse(date, DateTimeFormatter.ofPattern("MMyy")).equals(YearMonth.now())
        } catch (e: Exception) {
            false
        }
    }
}
class InvalidUsernameException(message: String) : Exception(message)