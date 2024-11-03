package com.hg.nc.repository

import com.hg.nc.entity.FollowRelationshipEntity
import org.springframework.data.repository.CrudRepository

interface FollowRelationshipRepository: CrudRepository<FollowRelationshipEntity, Long> {
    fun findAllByFollowerId(userId: String): List<FollowRelationshipEntity>
}
