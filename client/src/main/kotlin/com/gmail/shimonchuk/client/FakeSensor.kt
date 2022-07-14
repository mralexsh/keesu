package com.gmail.shimonchuk.client

class FakeSensor(fakeId: Int, fakeType: Int, initialValue:Int, private val emulationStrategy: EmulationStrategy) : Sensor {
    override val id: Int = fakeId
    override val type: Int = fakeType
    var emulationValue: Int = initialValue
    override val value: Int  get() = emulationValue
    override fun update() {
        emulationStrategy.doEmulate(this)
    }

}