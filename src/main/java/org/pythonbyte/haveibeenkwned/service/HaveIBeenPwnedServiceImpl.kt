package org.pythonbyte.haveibeenkwned.service

import org.json.JSONObject
import org.pythonbyte.haveibeenkwned.domain.Breach
import org.pythonbyte.krux.crypto.HashUtils
import org.pythonbyte.krux.json.JsonObject
import org.pythonbyte.krux.properties.PropertyReader

class HaveIBeenPwnedServiceImpl : HaveIBeenPwnedService {
    private val propertiesFile = "/haveibeenkwned.properties"
    private val propertyReader = PropertyReader(propertiesFile)

    override fun isPasswordPwned(password: String): Boolean {
        return isHashPwned(HashUtils.sha1(password))
    }

    override fun isHashPwned(passwordHash: String): Boolean {
        val baseUrl = propertyReader.get("haveibeenkwned.passwords.baseUrl")

        val response = khttp.get(baseUrl + passwordHash)
        return response.text.contains(passwordHash)
    }

    override fun getBreaches(emailAddress: String): List<Breach> {
        val baseUrl = propertyReader.get("haveibeenkwned.emailAddresses.baseUrl")

        val response = khttp.get(baseUrl + emailAddress)

        val breachJsonObjects = response.jsonArray.map { jsonObject -> JsonObject( jsonObject as JSONObject ) }

        return breachJsonObjects.map { breachJsonObject -> Breach.createFromJson( breachJsonObject ) }
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
