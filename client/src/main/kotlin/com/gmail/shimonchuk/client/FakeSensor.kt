package com.gmail.shimonchuk.client

class FakeSensor(id: Int, type: Int, value: Int, private val emulationStrategy: EmulationStrategy) : Sensor {
    var emulationValue: Int = 0

    override val id: Int get() = id
    override val type: Int get() = type
    override val value: Int  get() = emulationValue


    fun emulate() {
        emulationStrategy.doEmulate(this)
    }

}