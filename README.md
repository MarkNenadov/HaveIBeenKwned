# HaveIBeenKwned

A Kotlin interface to the haveibeenpwned.com API (https://haveibeenpwned.com/).

To use V3 endpoints (for instances breaches()), you will need to [subscribe to an API key](https://haveibeenpwned.com/API/Key) and put it in haveibeenkwned.properties. 

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
