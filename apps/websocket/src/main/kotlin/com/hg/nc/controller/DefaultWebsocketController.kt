package com.hg.nc.controller

import com.hg.nc.model.UserLocationPubRequest
import com.hg.nc.redis.event.RedisLocationSubscriber
import com.hg.nc.service.UserLocationService
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Controller

/**
 * 정책: 특정 사용자가 로그인하게 되면 친구 목록 API를 호출하여 친구 목록을 받는다.
 */
@Controller
class DefaultWebsocketController(
    private val userLocationService: UserLocationService,
    private val redisLocationSubscriber: RedisLocationSubscriber
) {

    /** /pub/message 클라이언트 요청 처리 */
    @MessageMapping("/location/update")
    fun handleLocationUpdate(@Payload message: UserLocationPubRequest) {

        userLocationService.saveLocation(
            userId = message.userId,
            latitude = message.latitude.toDouble(),
            longitude = message.longitude.toDouble()
        )
    }

    @MessageMapping("/user/{friendId}/location")
    fun subscribeToLocation(
        @DestinationVariable friendId: String,
        @Payload userId: String
    ): String {
        println("User $userId subscribing to location updates for friend: $friendId")

        redisLocationSubscriber.subscribeToFriendLocation(userId, friendId)
        return "Subscribed to $friendId location updates"
    }
}
