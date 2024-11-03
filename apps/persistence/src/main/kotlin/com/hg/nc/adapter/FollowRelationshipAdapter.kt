package com.hg.nc.adapter

import com.hg.nc.domain.FollowRelationship
import com.hg.nc.port.relationship.FollowRelationshipPort
import com.hg.nc.repository.FollowRelationshipRepository
import org.springframework.stereotype.Component

@Component
class FollowRelationshipAdapter(
    private val followRelationshipRepository: FollowRelationshipRepository
) : FollowRelationshipPort {
    override fun findFollowing(userId: String): List<FollowRelationship> {
        return followRelationshipRepository.findAllByFollowerId(userId).map { it.toDomain() }
    }
}
