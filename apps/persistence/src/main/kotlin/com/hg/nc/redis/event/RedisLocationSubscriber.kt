package com.hg.nc.redis.event

import com.hg.nc.port.redis.RedisLocationBroadcastPort
import com.hg.nc.port.redis.RedisLocationSubscriber
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.data.redis.connection.MessageListener
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class RedisLocationSubscriber(
    private val redisLocationBroadcastPort: RedisLocationBroadcastPort,
    private val redisConnectionFactory: RedisConnectionFactory,
) : RedisLocationSubscriber {

    private val container = RedisMessageListenerContainer().apply {
        setConnectionFactory(redisConnectionFactory)
        start()
    }

    override fun handleMessage(message: String) {
        logger.info { "Subscribe redis message $message" }

        // TODO: 안전하게 파싱할 수 있도록 수정 필요.
        val userId = message.split(",")[0]
        redisLocationBroadcastPort.broadcastLocationUpdate(userId, message)
    }

    override fun subscribeToFriendLocation(userId: String, friendId: String) {
        val topic = ChannelTopic("user:location:$friendId")
        container.addMessageListener(MessageListener { message, _ ->
            val locationUpdate = message.toString()
            logger.info { "Received location update for friend $friendId: $locationUpdate" }

            // WebSocket 구독 경로로 위치 업데이트 메시지 전송
            redisLocationBroadcastPort.broadcastLocationUpdate(userId, locationUpdate)
        }, topic)
    }
}
