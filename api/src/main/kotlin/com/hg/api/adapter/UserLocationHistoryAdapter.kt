package com.hg.api.adapter

import com.hg.api.domain.UserLocationHistory
import com.hg.api.entity.UserLocationHistoryEntity
import com.hg.api.repository.UserLocationHistoryRepository
import org.springframework.stereotype.Component

@Component
class UserLocationHistoryAdapter(
    val userLocationHistoryRepository: UserLocationHistoryRepository
) {

    fun saveUserLocationHistory(
        userLocationHistory: UserLocationHistory
    ) {
        userLocationHistoryRepository.save(UserLocationHistoryEntity.of(userLocationHistory))
    }

}
