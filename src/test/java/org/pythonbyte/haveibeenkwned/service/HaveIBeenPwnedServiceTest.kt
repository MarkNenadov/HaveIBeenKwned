package org.pythonbyte.haveibeenkwned.service

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

class HaveIBeenPwnedServiceTest {
    val haveIBeenPwnedService = HaveIBeenPwnedServiceImpl()

    @Test
    fun testIsPasswordPwnedWhenTrue() {
        assertFalse( haveIBeenPwnedService.isPasswordPwned("password") )
    }

    @Test
    fun testIsPasswordPwnedWhenFalse() {
        assertFalse( haveIBeenPwnedService.isPasswordPwned("fjrelwkfjrelkrgjf393498504358ejgkrjgr") )
    }
}