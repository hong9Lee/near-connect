package com.hg.nc.redis

import com.hg.nc.port.RedisLocationPublisher
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class RedisLocationPublisher(
    private val redisTemplate: RedisTemplate<String, String>,
): RedisLocationPublisher {
    override fun publishLocationUpdate(userId: String, latitude: Double, longitude: Double) {
        val channel = "location_update_channel:$userId"
        redisTemplate.convertAndSend(channel, "$userId,$latitude,$longitude")
    }
}
