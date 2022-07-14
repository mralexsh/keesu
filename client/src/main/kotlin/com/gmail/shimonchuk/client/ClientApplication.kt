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
            props.load(it)
            SensorsRuntime(props, emulationData) { c -> handleEmulationContent(c) }.start()
        }
    } ?: logger.error { "File $properties not found!" }
}

private fun handleEmulationContent(content: String) {
    logger.info { "-- CON++TENT --: $content" }
}
