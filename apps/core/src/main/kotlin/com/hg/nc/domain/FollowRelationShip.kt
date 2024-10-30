package com.hg.nc.domain

import java.time.ZonedDateTime

data class FollowRelationShip(
    val seq: Long? = null,
    val followerId: String,
    val followedId: String,
    var eventDateTime: ZonedDateTime? = ZonedDateTime.now(),
    var isActive: Boolean = false
)
