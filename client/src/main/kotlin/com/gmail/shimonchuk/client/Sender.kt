package com.gmail.shimonchuk.client

import mu.KotlinLogging
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.util.Properties

class Sender(props: Properties) {
    private val okHttpClient = OkHttpClient()
    private val url: String = props.getProperty("server.url")
    private val mediaType = "application/json; charset=utf-8".toMediaType()

    private val logger = KotlinLogging.logger {}
    fun send(payload: String) {
        val request = Request.Builder()
            .addHeader("Content-Type", "application/json")
            .method("POST", payload.toRequestBody(mediaType))
            .url(url)
            .build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                logger.error { "++  Fail to send ++" }
            }

            override fun onResponse(call: Call, response: Response) {
                logger.info { "++  SUCCESS ++" }
            }
        })
    }

}