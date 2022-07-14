package com.gmail.shimonchuk.client

import mu.KotlinLogging
import java.util.*
import kotlin.concurrent.thread

class SensorsRuntime(props: Properties, private val sensors: List<Sensor>) {

    private val logger = KotlinLogging.logger {}
    private val pollingInterval: Long = props.getProperty("polling.interval").toLong()
    private val jitterSize: Long = props.getProperty("jitter.size").toLong()
    private val jitterCounter: Long = 0
    fun start() {
        thread {
            while (true) {
                update()
                Thread.sleep(pollingInterval)
            }
        }
    }

    private fun update() {
        sensors.forEach {
            sensor -> sensor.update()
            logger.info { "Sensor ID=${sensor.id} VALUE=${sensor.value}" }
        }

    }
}