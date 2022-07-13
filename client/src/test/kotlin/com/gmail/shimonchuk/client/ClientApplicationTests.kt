package com.gmail.shimonchuk.client

import com.gmail.shimonchuk.client.strategies.SimpleDigital
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ClientApplicationTests {

    @Test
    fun digital1() {
        var ticks: Int = 3
        var expected: Int = 0

        val fakeSensor = FakeSensor(1, 1, 0, SimpleDigital(ticks))
        for (i in 1..13764) {
            fakeSensor.emulate()
            if (i % ticks == 0) {
                if (expected == 0) expected = 1 else expected = 0
            }
            assertEquals(expected, fakeSensor.emulationValue)
        }
    }

}
