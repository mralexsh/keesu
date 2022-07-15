package com.gmail.shimonchuk.backend

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class Snapshot(
    val name: String,
    val description: String,
    val trends: HashMap<Int, MutableList<Int>>,
    val timestamp: Long
)