package com.hg.api.repository

import com.hg.api.entity.UserLocationHistoryEntity
import org.springframework.data.repository.CrudRepository

interface UserLocationHistoryRepository: CrudRepository<UserLocationHistoryEntity, Long> {
}
