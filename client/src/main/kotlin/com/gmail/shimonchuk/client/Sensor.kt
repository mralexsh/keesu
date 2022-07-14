package com.gmail.shimonchuk.client

interface Sensor {
    val id: Int
    val type: Int
    val value: Int
    fun update()
}