# HaveIBeenKwned

A Kotlin interface to the haveibeenpwned.com API (https://haveibeenpwned.com/).

NOTE: This project is broken until support for V3 API is introduced.

### Service ###

```
interface HaveIBeenPwnedService {
    fun isPasswordPwned(password: String): Boolean
    fun isHashPwned(passwordHash: String): Boolean
    fun getBreaches() : List<Breach>
    fun getBreaches(emailAddress: String) : List<Breach>
    fun getVersion(): Int
}
```

### Releases ###

* [https://github.com/MarkNenadov/HaveIBeenKwned/releases/tag/v0.1](v0.1)
