package org.pythonbyte.haveibeenkwned.service

interface HaveIBeenPwnedService {
    fun isPasswordPwned(password: String): Boolean
}