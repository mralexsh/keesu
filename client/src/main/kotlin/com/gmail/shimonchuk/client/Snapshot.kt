package com.gmail.shimonchuk.client

import kotlinx.serialization.Serializable

@Serializable
data class Snapshot(val name: String, val description: String, val trends: HashMap<Int, MutableList<Int>>) {
}