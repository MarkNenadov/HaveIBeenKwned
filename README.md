# HaveIBeenKwned

A Kotlin library to access the haveibeenpwned.com API

### Service ###

interface HaveIBeenPwnedService {
    fun isPasswordPwned(password: String): Boolean
}
