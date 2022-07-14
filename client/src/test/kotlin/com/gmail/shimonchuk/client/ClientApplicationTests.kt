package com.gmail.shimonchuk.client

import com.gmail.shimonchuk.client.strategies.SimpleAnalog
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
            fakeSensor.update()
            if (i % ticks == 0) {
                if (expected == 0) expected = 1 else expected = 0
            }
            assertEquals(expected, fakeSensor.emulationValue)
        }
    }

    @Test
    fun analog() {
        val min = 3
        val max = 67
        val ticks = 23
        val fakeSensor = FakeSensor(1, 0, min, SimpleAnalog(ticks, min, max))
        val range = (max - min) * ticks

        for (i in (0 until range)) {
            fakeSensor.update()
            val t: Int = min + (i + 1) / ticks
            assertEquals(fakeSensor.emulationValue, t)
        }
        assertEquals(fakeSensor.emulationValue, max)
        for (i in (0 until range)) {
            fakeSensor.update()
            val t: Int = max - (i + 1) / ticks
            assertEquals(fakeSensor.emulationValue, t)
        }
        assertEquals(fakeSensor.emulationValue, min)

    }

}
