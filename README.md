# HaveIBeenKwned

A Kotlin interface to the haveibeenpwned.com API (https://haveibeenpwned.com/).

### Service ###

```
interface HaveIBeenPwnedService {
    // these don't require an API key
    fun isPasswordPwned(password: String): Boolean
    fun isHashPwned(passwordHash: String): Boolean
    fun getVersion(): Int
    
    // these require an API (they are v3)
    fun breaches(emailAddress: String): List<Breach>
}
```

### Releases ###
* [v0.2](https://github.com/MarkNenadov/HaveIBeenKwned/releases/tag/v0.2)
