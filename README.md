# HaveIBeenKwned

A Kotlin interface to the haveibeenpwned.com API (https://haveibeenpwned.com/).

### Service ###

interface HaveIBeenPwnedService {
    fun isPasswordPwned(password: String): Boolean
}
