package com.gmail.shimonchuk.client

import mu.KotlinLogging
import java.util.Properties

class Sender(private val props: Properties) {
    private val logger = KotlinLogging.logger {}
    fun send(payload: String) {
        logger.info { "++  $payload ++" }
    }

}