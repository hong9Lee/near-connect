package com.hg.nc.service

import com.hg.nc.port.redis.RedisLocationBroadcastPort
import com.hg.nc.port.redis.RedisLocationCachePort
import com.hg.nc.port.relationship.FollowRelationshipPort
import com.hg.nc.port.user.UserPort
import com.hg.nc.port.websocket.WebSocketInitializationPort
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class SessionInitializationService(
    private val userPort: UserPort,
    private val followRelationshipPort: FollowRelationshipPort,
    private val redisLocationCachePort: RedisLocationCachePort,
    private val webSocketInitializationPort: WebSocketInitializationPort,
    private val redisLocationBroadcastPort: RedisLocationBroadcastPort
) {

    fun init(
        userId: String,
        latitude: BigDecimal,
        longitude: BigDecimal
    ) {
        // user 검증
        if (!checkValidUser(userId)) return

        // user follow relationship 조회
        val followRelationShipList = followRelationshipPort.findFollowing(userId)
        val followedIdSet = followRelationShipList.map { it.followedId }.toSet()

        // redis에 캐싱 되어있는 위치 정보 조회
        val friendLocations = redisLocationCachePort.getLocationsByUserIds(followedIdSet)

        // 팔로잉 친구 웹소켓 채널 전부 구독
        sendInitializationToWebSocket(userId, followedIdSet, friendLocations)

        // 나의 위치 broadcast
        broadcastUserLocation(userId, latitude, longitude)
    }

    private fun checkValidUser(userId: String): Boolean = userId.isNullOrEmpty() || findUser(userId)

    private fun findUser(userId: String): Boolean {
        return userPort.isUserExists(userId) != null
    }

    private fun sendInitializationToWebSocket(userId: String, followedIdSet: Set<String>, friendLocations: Map<String, String>) {
        webSocketInitializationPort.initializeSession(
            userId = userId,
            friendIds = followedIdSet,
            friendLocations = friendLocations
        )
    }

    private fun broadcastUserLocation(userId: String, latitude: BigDecimal, longitude: BigDecimal) {
        val locationMessage = "$latitude,$longitude"
        redisLocationBroadcastPort.broadcastLocationUpdate(userId, locationMessage)
    }

}
