package org.pythonbyte.haveibeenkwned.service

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

class HaveIBeenPwnedServiceTest {
    @Test
    fun testIsPasswordPwnedWhenTrue() {
        val haveIBeenPwnedService = HaveIBeenPwnedServiceImpl()
        assertFalse( haveIBeenPwnedService.isPasswordPwned("password") )
    }

    @Test
    fun testIsPasswordPwnedWhenFalse() {
        val haveIBeenPwnedService = HaveIBeenPwnedServiceImpl()
        assertFalse( haveIBeenPwnedService.isPasswordPwned("fjrelwkfjrelkrgjf393498504358ejgkrjgr") )
    }
}