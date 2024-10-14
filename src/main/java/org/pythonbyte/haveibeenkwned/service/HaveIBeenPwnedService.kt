package org.pythonbyte.haveibeenkwned.service

interface HaveIBeenPwnedService {
    fun isPasswordPwned(password: String): Boolean
    fun isHashPwned(passwordHash: String): Boolean
    fun getVersion(): Int
}
