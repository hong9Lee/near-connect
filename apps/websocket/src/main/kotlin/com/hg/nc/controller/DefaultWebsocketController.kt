package com.hg.nc.controller

import com.hg.nc.service.UserLocationService
import com.hg.nc.model.UserLocationPubRequest
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller

@Controller
class DefaultWebsocketController(
    private val simpMessagingTemplate: SimpMessagingTemplate,
    private val userLocationService: UserLocationService
) {

    /** /pub/message 클라이언트 요청 처리 */
    @MessageMapping("/location/update")
    fun handleLocationUpdate(@Payload message: UserLocationPubRequest) {

        userLocationService.saveLocation(
            userId = message.userId,
            latitude = message.latitude.toDouble(),
            longitude = message.longitude.toDouble()
        )

        simpMessagingTemplate.convertAndSend("/sub/location", message)
    }
}
