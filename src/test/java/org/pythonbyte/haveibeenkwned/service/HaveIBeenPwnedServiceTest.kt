package org.pythonbyte.haveibeenkwned.service

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
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
}
