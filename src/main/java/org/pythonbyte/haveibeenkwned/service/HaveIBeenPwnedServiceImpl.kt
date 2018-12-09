package org.pythonbyte.haveibeenkwned.service

import com.mcxiaoke.koi.HASH
import org.pythonbyte.haveibeenkwned.base.util.PropertyReader

class HaveIBeenPwnedServiceImpl : HaveIBeenPwnedService {
    private val propertiesFile = "/haveibeenkwned.properties"
    private val propertyReader = PropertyReader(propertiesFile)

    override fun isPasswordPwned(password: String): Boolean {
        return isHashPwned(HASH.sha1(password))
    }

    override fun isHashPwned(passwordHash: String): Boolean {
        val baseUrl = propertyReader.get("haveibeenkwned.passwords.baseUrl")

        val response = khttp.get(baseUrl + passwordHash)
        return response.text.contains(passwordHash)
    }
}