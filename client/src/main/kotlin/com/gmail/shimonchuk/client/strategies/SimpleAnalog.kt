package com.gmail.shimonchuk.client.strategies

import com.gmail.shimonchuk.client.EmulationStrategy
import com.gmail.shimonchuk.client.FakeSensor


class SimpleAnalog(private val ticks: Int, private val min: Int, private val max: Int) : EmulationStrategy {

    private var direction: Int = 1
    private var counter: Int = 0
    private var value: Int = min

    override fun doEmulate(sensor: FakeSensor) {
        counter++
        if (counter == ticks) {
            counter = 0
            value += calcDirection()
        }
        sensor.emulationValue = value
    }

    private fun calcDirection(): Int {
        if (value >= max) {
            direction = -1
        }
        if (value <= min) {
            direction = 1
        }
        return direction
    }

}