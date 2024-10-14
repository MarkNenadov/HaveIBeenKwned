package org.pythonbyte.haveibeenkwned.service

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class HaveIBeenPwnedServiceTest {
    private val haveIBeenPwnedService = HaveIBeenPwnedServiceImpl()

    @Test
    fun testIsPasswordPwnedWhenTrue() {
        assertTrue(haveIBeenPwnedService.isPasswordPwned("password"))
    }

    @Test
    fun testIsPasswordPwnedWhenFalse() {
        assertFalse(haveIBeenPwnedService.isPasswordPwned("fjrelwkfjrelkrgjf393498504358ejgkrjgr"))
    }

    @Test
    fun testBreaches() {
        val items = haveIBeenPwnedService.breaches("johnsmith@gmail.com")
        assertTrue(items.size > 10)
        assertTrue(items.any { it.domain.equals("advanceautoparts.com") })
    }

    @Test
    fun testBreachesWhenNone() {
        val items = haveIBeenPwnedService.breaches("thisemailwillnotexist@testw39343.com")
        assertEquals(0, items.size)
    }

}
