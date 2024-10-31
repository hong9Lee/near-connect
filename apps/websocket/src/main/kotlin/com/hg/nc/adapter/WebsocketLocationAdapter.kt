package com.hg.nc.adapter

import com.hg.nc.port.redis.RedisLocationBroadcastPort
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Component

@Component
class WebsocketLocationAdapter(
    private val simpMessagingTemplate: SimpMessagingTemplate
) : RedisLocationBroadcastPort {
    override fun broadcastLocationUpdate(userId: String, message: String) {
        val channel = "/sub/location/$userId"
        simpMessagingTemplate.convertAndSend(channel, message)
    }
}
