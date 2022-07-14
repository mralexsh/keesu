package com.gmail.shimonchuk.client

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Snapshot(
    val name: String,
    val description: String,
    val trends: HashMap<Int, MutableList<Int>>,
    val timestamp: Long = Date().time
) {
}