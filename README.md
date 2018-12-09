# HaveIBeenKwned

A Kotlin library to access the haveibeenpwned.com API (https://haveibeenpwned.com/).

### Service ###

interface HaveIBeenPwnedService {
    fun isPasswordPwned(password: String): Boolean
}
