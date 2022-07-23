package com.gmail.shimonchuk.backend

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class TrendsService(@Value("\${trends.service.buffer.size}") private val bufferSize: Int) {
    private val logger = LoggerFactory.getLogger(this.javaClass)
    val snapshots : HashMap<String, MutableList<Snapshot>> = HashMap()

    fun put(snapshot: Snapshot) {
        snapshots[snapshot.name]?.apply {
            add(snapshot)
            if (size > bufferSize) remove(last())
        } ?: let {
            snapshots[snapshot.name] = mutableListOf(snapshot)
        }
    }

    fun fetch(): String {
        val om = ObjectMapper()
        return om.writeValueAsString(SnapshotView(snapshots))
    }

}