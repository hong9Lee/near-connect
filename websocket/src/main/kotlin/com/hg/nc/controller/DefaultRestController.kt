package com.hg.nc.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
class DefaultRestController {

    @GetMapping("/ping")
    fun healthCheck(): ResponseEntity<Void> {
        logger.info { "pong" }
        return ok().build()
    }
}
