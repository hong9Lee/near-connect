package com.hg.nc.port.relationship

import com.hg.nc.domain.FollowRelationship

interface FollowRelationshipPort {
    fun findFollowing(userId: String): List<FollowRelationship>
}
