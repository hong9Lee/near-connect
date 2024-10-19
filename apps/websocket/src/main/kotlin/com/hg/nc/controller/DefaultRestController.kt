package com.hg.nc.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DefaultRestController {

    @GetMapping("/ping")
    fun healthCheck(): ResponseEntity<Void> {
        return ResponseEntity.ok().build()
    }
}
