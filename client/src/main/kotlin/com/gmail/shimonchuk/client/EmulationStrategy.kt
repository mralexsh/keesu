package com.gmail.shimonchuk.client

interface EmulationStrategy {
    fun doEmulate(sensor: FakeSensor)
}