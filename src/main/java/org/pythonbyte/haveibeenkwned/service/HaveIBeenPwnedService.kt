package org.pythonbyte.haveibeenkwned.service

import org.pythonbyte.haveibeenkwned.domain.Breach

interface HaveIBeenPwnedService {
    fun isPasswordPwned(password: String): Boolean
    fun isHashPwned(passwordHash: String): Boolean
    fun getBreaches() : List<Breach>
    fun getVersion(): Int
}