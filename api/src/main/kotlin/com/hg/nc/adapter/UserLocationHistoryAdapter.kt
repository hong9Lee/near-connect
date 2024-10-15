package com.hg.nc.adapter

import com.hg.nc.domain.UserLocationHistory
import com.hg.nc.entity.UserLocationHistoryEntity
import com.hg.nc.repository.UserLocationHistoryRepository
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
