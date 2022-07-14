package com.gmail.shimonchuk.client

class FakeSensor(fakeId: Int, fakeType: Int, private val emulationStrategy: EmulationStrategy) : Sensor {
    override val id: Int = fakeId
    override val type: Int = fakeType
    var emulationValue: Int = 0
    override val value: Int  get() = emulationValue
    override fun update() {
        emulationStrategy.doEmulate(this)
    }

}