package com.gmail.shimonchuk.client.strategies

import com.gmail.shimonchuk.client.EmulationStrategy
import com.gmail.shimonchuk.client.FakeSensor

class SimpleDigital(private val ticks: Int) : EmulationStrategy {
    private var counter: Int = 0

    override fun doEmulate(sensor: FakeSensor) {
        counter ++
        if (counter == ticks) {
            counter = 0
            if (sensor.emulationValue == 0) sensor.emulationValue = 1 else sensor.emulationValue = 0
        }
    }

}