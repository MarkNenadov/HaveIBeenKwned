package org.pythonbyte.haveibeenkwned.service

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

class HaveIBeenPwnedServiceTest {
    val haveIBeenPwnedService = HaveIBeenPwnedServiceImpl()

    @Test
    fun testIsPasswordPwnedWhenTrue() {
        assertFalse(haveIBeenPwnedService.isPasswordPwned("password"))
    }

    @Test
    fun testIsPasswordPwnedWhenFalse() {
        assertFalse(haveIBeenPwnedService.isPasswordPwned("fjrelwkfjrelkrgjf393498504358ejgkrjgr"))
    }

    @Test
    fun testGetBreaches() {
        assertTrue(haveIBeenPwnedService.getBreaches().size > 0)
    }

    @Test
    fun testGetBreachesByEmail() {
        val breaches = haveIBeenPwnedService.getBreaches("bob@gmail.com")
        assertTrue(breaches.size > 0)
    }
}
