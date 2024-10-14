package org.pythonbyte.haveibeenkwned.domain

import org.pythonbyte.krux.json.JsonObject

class Breach {
    var name: String? = null
    var title: String? = null
    var description: String? = null
    var breachDate: String? = null
    var domain: String? = null

    companion object {
        fun fromJson(it: JsonObject): Breach {
            return Breach().apply {
                name = it.getString("Name")
                description = it.getString("Description")
                title = it.getString("Title")
                breachDate = it.getString("BreachDate")
                domain = it.getString("Domain")
            }
        }
    }
}