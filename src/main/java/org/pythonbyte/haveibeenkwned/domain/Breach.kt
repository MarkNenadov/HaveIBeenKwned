package org.pythonbyte.haveibeenkwned.domain

import org.pythonbyte.haveibeenkwned.base.json.JsonObject

class Breach {
    var name: String = ""
    var title: String = ""
    var domain: String = ""
    var description: String = ""
    var logoPath: String = ""
    var breachDate: String = ""
    var pwnCount: Int = 0

    companion object {
        fun createFromJson( jsonObject: JsonObject) : Breach {
            val breach = Breach()

            breach.name = jsonObject.getString("Name")
            breach.title = jsonObject.getString("Title")
            breach.domain = jsonObject.getString("Domain")
            breach.description = jsonObject.getString("Description")
            breach.logoPath = jsonObject.getString("LogoPath")
            breach.breachDate = jsonObject.getString("BreachDate")
            breach.pwnCount = jsonObject.getInt("PwnCount")

            return breach;
        }
    }
}
