package com.hg.nc.repository

import com.hg.nc.entity.FollowRelationshipEntity
import com.hg.nc.entity.UserLocationHistoryEntity
import org.springframework.data.repository.CrudRepository

interface FollowRelationshipRepository: CrudRepository<FollowRelationshipEntity, Long> {
}
