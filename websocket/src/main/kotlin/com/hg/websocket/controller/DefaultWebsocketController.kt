package com.hg.websocket.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

private val logger = KotlinLogging.logger {}

@Controller
class DefaultWebsocketController {

    /** /pub/message 클라이언트 요청 처리 */
    @MessageMapping("/location/update")
    @SendTo("/sub/location")
    fun handleLocationUpdate(message: String): String {
        logger.info { "Received location update: $message" }

        return message
    }
}
