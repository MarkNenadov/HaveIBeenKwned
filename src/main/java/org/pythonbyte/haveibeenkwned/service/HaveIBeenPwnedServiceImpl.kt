package org.pythonbyte.haveibeenkwned.service

import okhttp3.Headers
import org.pythonbyte.haveibeenkwned.domain.Breach
import org.pythonbyte.krux.crypto.HashUtils.sha1
import org.pythonbyte.krux.http.*
import org.pythonbyte.krux.properties.PropertyReader

class HaveIBeenPwnedServiceImpl : HaveIBeenPwnedService {
    private val propertiesFile = "/haveibeenkwned.properties"
    private val propertyReader = PropertyReader(propertiesFile)

    override fun isPasswordPwned(password: String): Boolean {
        return isHashPwned(password.sha1())
    }

    override fun isHashPwned(passwordHash: String): Boolean {
        val baseUrl = propertyReader.get("haveibeenkwned.passwords.baseUrl")

        val firstFiveOfHash = passwordHash.take(5)
        val restOfHash = passwordHash.replaceFirst(firstFiveOfHash, "").uppercase()

        val request = buildGetRequest(baseUrl + firstFiveOfHash, Headers.Builder().build())
        val responseText = String(sendRequest(request).getBytes())

        return responseText.contains(restOfHash)
    }

    private fun generateHeaders(): Headers {
        return Headers.Builder().apply {
            add("user-agent", "HaveIBeenKwned (Kotlin)")
            add("hibp-api-key", propertyReader.get("haveibeenkwned.v3.apiKey") )
            add("Content-Type", "application/json")
        }.build()
    }

    override fun breaches(emailAddress: String): List<Breach> {
        val baseUrl = propertyReader.get("haveibeenkwned.v3.baseUrl")
        val request = buildGetRequest(
            baseUrl + "breachedaccount/$emailAddress",
            generateHeaders(),
        )
        val response = sendRequest(request)
        val jsonArray = response.getJsonArray()
        return jsonArray.map {
            Breach.fromJson(it)
        }
    }


    override fun getVersion() = 3
}
