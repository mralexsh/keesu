package com.gmail.shimonchuk.backend

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.async.DeferredResult
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.io.IOException
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


@RestController
@RequestMapping("/sensors")
class SensorsController {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @RequestMapping(method = [RequestMethod.POST])
    fun postSensors(@RequestBody snapshot: Snapshot): DeferredResult<ResponseEntity<String>> {
        val result = DeferredResult<ResponseEntity<String>>(TimeUnit.SECONDS.toMillis(10))

        result.setResult(ResponseEntity.ok("OK"))
        return result;
    }

    @GetMapping("/trends")
    fun trends(): SseEmitter? {
        val emitter = SseEmitter()
        val executor = Executors.newSingleThreadExecutor()
        executor.execute {
            try {
                emitter.send("Hello FROM SSE")
                emitter.complete()
            } catch (e: IOException) {
                emitter.completeWithError(e)
            }
        }
        executor.shutdown()
        return emitter
    }

}