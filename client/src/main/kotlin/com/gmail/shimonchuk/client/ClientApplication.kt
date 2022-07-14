package com.gmail.shimonchuk.client

import mu.KotlinLogging
import java.util.*
import kotlin.collections.ArrayList

class ClientApplication
private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
    val properties = "application.properties"

    ClassLoader.getSystemResource(properties)?.apply {
        openStream().use {
            val props = Properties()
            props.load(it)
            SensorsRuntime(props, emulationData).start()
        }
    } ?: logger.error { "File $properties not found!" }
}
