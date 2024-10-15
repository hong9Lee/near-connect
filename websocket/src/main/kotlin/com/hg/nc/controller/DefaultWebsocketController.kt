package com.hg.nc.controller

import com.hg.nc.model.UserLocationPubRequest
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller

private val logger = KotlinLogging.logger {}

@Controller
class DefaultWebsocketController(
    private val simpMessagingTemplate: SimpMessagingTemplate
) {

    /** /pub/message 클라이언트 요청 처리 */
    @MessageMapping("/location/update")
    fun handleLocationUpdate(@Payload message: UserLocationPubRequest){
        logger.info { "Received location update: $message" }

        simpMessagingTemplate.convertAndSend("/sub/location", message)
    }
}
