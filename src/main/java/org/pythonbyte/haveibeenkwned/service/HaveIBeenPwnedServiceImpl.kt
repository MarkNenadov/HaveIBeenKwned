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

        val request = buildGetRequest(baseUrl + firstFiveOfHash, buildHeaders(emptyMap()))
        val responseText = String(sendRequest(request!!).getBytes())

        return responseText.contains(restOfHash)
    }

    private fun generateHeaders(): Headers =
        buildHeaders(
            mapOf(
                "user-agent" to "HaveIBeenKwned (Kotlin)",
                "hibp-api-key" to propertyReader.get("haveibeenkwned.v3.apiKey"),
                "Content-Type" to "application/json",
            )
        )

    override fun breaches(emailAddress: String): List<Breach> {
        val baseUrl = propertyReader.get("haveibeenkwned.v3.baseUrl")
        val request = buildGetRequest(
            baseUrl + "breachedaccount/$emailAddress",
            generateHeaders(),
        )
        val response = sendRequest(request!!)
        val jsonArray = response.getJsonArray()
        return jsonArray.map {
            Breach.fromJson(it)
        }
    }


    override fun getVersion() = 3
}
