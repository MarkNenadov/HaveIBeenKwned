package org.pythonbyte.haveibeenkwned.service

import com.squareup.okhttp.Headers
import org.pythonbyte.krux.crypto.HashUtils.sha1
import org.pythonbyte.krux.http.HttpResponse
import org.pythonbyte.krux.http.buildGetRequest
import org.pythonbyte.krux.http.sendRequest
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
        val response = HttpResponse(sendRequest(request).getResponse())
        val responseText = String(response.getBytes())

        return responseText.contains(restOfHash)
    }

    override fun getVersion() = 2
}
