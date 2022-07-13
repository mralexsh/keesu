package com.gmail.shimonchuk.client

import mu.KotlinLogging
import java.util.*
import kotlin.concurrent.thread

class SensorsRuntime(props: Properties) {
    private val logger = KotlinLogging.logger {}
    private val pollingInterval: Long = props.getProperty("polling.interval").toLong()
    private val jitterSize: Long = props.getProperty("jitter.size").toLong()

    fun start(runtimeLogic: () -> Unit) {
        thread {
            while (true) {
                runtimeLogic()
                Thread.sleep(pollingInterval)
            }
        }
    }
}