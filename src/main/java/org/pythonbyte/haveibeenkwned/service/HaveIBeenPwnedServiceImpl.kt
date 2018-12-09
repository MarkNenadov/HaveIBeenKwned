package org.pythonbyte.haveibeenkwned.service

import com.mcxiaoke.koi.HASH
import org.pythonbyte.haveibeenkwned.base.util.PropertyReader

class HaveIBeenPwnedServiceImpl : HaveIBeenPwnedService {
    private val propertiesFile = "/haveibeenkwned.properties"
    private val propertyReader = PropertyReader(propertiesFile)

    override fun isPasswordPwned(password: String) : Boolean {
        val baseUrl = propertyReader.get( "haveibeenkwned.passwords.baseUrl" )
        val hash = HASH.sha1( password )

        val response = khttp.get( baseUrl + hash )
        return response.text.contains( hash )
    }
}