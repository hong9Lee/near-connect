package com.hg.nc.service

import com.hg.nc.port.relationship.FollowRelationshipPort
import com.hg.nc.port.user.UserLocationHistoryPort
import com.hg.nc.port.user.UserPort
import org.springframework.stereotype.Service

@Service
class SessionInitializationService(
    private val userPort: UserPort,
    private val followRelationshipPort: FollowRelationshipPort
) {

    fun init(
        userId: String
    ) {
        // user 검증
        if (!checkValidUser(userId)) return

        // user follow relationship 조회
        val followRelationShipList = followRelationshipPort.findFollowing(userId)
        val followedIdSet = followRelationShipList.map { it.followedId }.toSet()

        // redis에 캐싱 되어있는 위치 정보 조회


        // 팔로잉 친구 웹소켓 채널 전부 구독

        // 나의 위치 broadcast

    }

    private fun checkValidUser(userId: String): Boolean = userId.isNullOrEmpty() || findUser(userId)

    private fun findUser(userId: String): Boolean {
        return userPort.isUserExists(userId) != null
    }

}
