package com.gmail.shimonchuk.client

import mu.KotlinLogging
import java.util.*

class ClientApplication
private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
    val properties = "application.properties"
    ClassLoader.getSystemResource(properties)?.apply {
        openStream().use {
            val props = Properties()
            val sender = Sender(props)
            props.load(it)
            SensorsRuntime(props, emulationData) { c -> sender.send(c) }.start()
        }
    } ?: logger.error { "File $properties not found!" }
}
