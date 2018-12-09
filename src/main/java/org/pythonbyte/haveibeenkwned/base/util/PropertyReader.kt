package org.pythonbyte.haveibeenkwned.base.util

import java.util.*

class PropertyReader(val propertiesFile : String) {
    val properties = Properties()

    init {
        properties.load(PropertyReader::class.java.getResourceAsStream(propertiesFile))
    }

    fun get(propertyName: String): String {
        return properties.getProperty( propertyName )
    }
}