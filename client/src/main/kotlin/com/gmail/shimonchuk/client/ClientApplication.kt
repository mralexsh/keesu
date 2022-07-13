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
            SensorsRuntime(props).start { logger.info { "Sensor ++ " } }
        }
    } ?: logger.error { "File $properties not found!" }
}
