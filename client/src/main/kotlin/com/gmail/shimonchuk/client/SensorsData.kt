package com.gmail.shimonchuk.client

import com.gmail.shimonchuk.client.strategies.SimpleAnalog
import com.gmail.shimonchuk.client.strategies.SimpleDigital

val emulationData = listOf(
    FakeSensor(1, 1, 0,SimpleDigital(10)),
    FakeSensor(2, 1, 0,SimpleDigital(20)),
    FakeSensor(3, 1, 0,SimpleDigital(30)),
    FakeSensor(4, 1, 0,SimpleDigital(50)),

    FakeSensor(5, 2, 3,SimpleAnalog(10, 3, 200)),
    FakeSensor(6, 2, 1,SimpleAnalog(3, 1, 300)),
    FakeSensor(7, 2, 1,SimpleAnalog(4, 1, 500)),
    FakeSensor(8, 2, 3,SimpleAnalog(2, 3, 300)),
)