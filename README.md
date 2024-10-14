# HaveIBeenKwned

A Kotlin interface to the haveibeenpwned.com API (https://haveibeenpwned.com/).

NOTE: I dropped breaches support until I have a chance to introduce API v3 support.

### Service ###

```
interface HaveIBeenPwnedService {
    fun isPasswordPwned(password: String): Boolean
    fun isHashPwned(passwordHash: String): Boolean
    fun getVersion(): Int
}
```

### Releases ###
* [https://github.com/MarkNenadov/HaveIBeenKwned/releases/v0.2](v0.2)
