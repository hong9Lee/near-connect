package com.hg.nc.redis.event

import com.hg.nc.port.redis.RedisLocationPublisher
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class RedisLocationPublisher(
    private val redisTemplate: RedisTemplate<String, String>
) : RedisLocationPublisher {
    override fun publishLocationUpdate(userId: String, latitude: Double, longitude: Double) {
        logger.info { "redis publish location update $userId, $latitude, $longitude" }

        val channelName = "location_updates:$userId"
        redisTemplate.convertAndSend(channelName, "$userId,$latitude,$longitude")
    }
}
