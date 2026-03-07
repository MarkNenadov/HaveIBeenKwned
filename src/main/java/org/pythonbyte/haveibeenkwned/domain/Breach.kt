package org.pythonbyte.haveibeenkwned.domain

import org.pythonbyte.krux.json.JsonObject

data class Breach(
    val name: String,
    val title: String,
    val description: String,
    val breachDate: String,
    val domain: String,
) {
    companion object {
        fun fromJson(it: JsonObject) = Breach(
            name = it.getString("Name") ?: "",
            description = it.getString("Description") ?: "",
            title = it.getString("Title") ?: "",
            breachDate = it.getString("BreachDate") ?: "",
            domain = it.getString("Domain") ?: "",
        )
    }
}