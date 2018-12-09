package org.pythonbyte.haveibeenkwned.service

import com.mcxiaoke.koi.HASH
import org.json.JSONObject
import org.pythonbyte.haveibeenkwned.base.json.JsonObject
import org.pythonbyte.haveibeenkwned.base.util.PropertyReader
import org.pythonbyte.haveibeenkwned.domain.Breach

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

    override fun getVersion(): Int {
        return 2
    }

    override fun getBreaches() : List<Breach> {
        val result = mutableListOf<Breach>()
        val baseUrl = propertyReader.get( "haveibeenkwned.base.baseUrl" )

        val response = khttp.get( baseUrl + "breaches" )
        response.jsonArray.forEach{
            result.add( Breach.createFromJson( JsonObject( it as JSONObject) ) )
        }

        return result;
    }
}