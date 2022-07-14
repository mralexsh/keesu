package com.gmail.shimonchuk.client

import com.gmail.shimonchuk.client.strategies.SimpleDigital

val emulationData = listOf(
    FakeSensor(1, 1, SimpleDigital(10)),
    FakeSensor(2, 1, SimpleDigital(20)),
    FakeSensor(3, 1, SimpleDigital(30)),
    FakeSensor(4, 1, SimpleDigital(50)),
)