package com.gmail.shimonchuk.client

import mu.KotlinLogging
import java.util.*
import kotlin.concurrent.thread
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlin.collections.HashMap

class SensorsRuntime(props: Properties, private val sensors: List<Sensor>, private  val fn: (m: String) -> Unit) {

    private val logger = KotlinLogging.logger {}
    private val pollingInterval: Long = props.getProperty("polling.interval").toLong()
    private val jitterSize: Int = props.getProperty("jitter.size").toInt()
    private val nodeName: String = props.getProperty("node.name")
    private val nodeDescription: String = props.getProperty("node.description")
    private val trends: HashMap<Int, MutableList<Int>> = makeTrends(sensors)
    private var jitterCounter: Int = 0
    fun start() {
        logger.info { "Start runtime thread" }
        thread {
            while (true) {
                update()
                Thread.sleep(pollingInterval)
            }
        }
    }

    private fun update() {
        sensors.forEach { s -> s.update() }
        trends.forEach { t -> sensors.find { t.key == it.id }?.let { t.value.add(it.value) } }
        if (jitterCounter < jitterSize) {
            jitterCounter++
        } else {
            fn(Json.encodeToString(Snapshot(nodeName, nodeDescription, trends, Date().time)))
            trends.forEach { t -> t.value.clear() }
            jitterCounter = 0
        }
    }

    private fun makeTrends(s: List<Sensor>): HashMap<Int, MutableList<Int>> {
        val result: HashMap<Int, MutableList<Int>> = HashMap()
        s.forEach { sensor -> result[sensor.id] = MutableList(jitterSize) { 0 } }
        return result
    }


}