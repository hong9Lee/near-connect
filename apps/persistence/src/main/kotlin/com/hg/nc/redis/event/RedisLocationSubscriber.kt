package com.hg.nc.redis.event

import com.hg.nc.port.RedisLocationBroadcastPort
import com.hg.nc.port.RedisLocationSubscriber
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class RedisLocationSubscriber(
    private val redisLocationBroadcastPort: RedisLocationBroadcastPort
) : RedisLocationSubscriber {

    override fun handleMessage(message: String) {
        logger.info { "Subscribe redis message $message" }

        // TODO: 안전하게 파싱할 수 있도록 수정 필요.
        val userId = message.split(",")[0]
        redisLocationBroadcastPort.broadcastLocationUpdate(userId, message)
    }
}
