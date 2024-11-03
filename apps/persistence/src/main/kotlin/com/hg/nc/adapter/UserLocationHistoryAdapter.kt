package com.hg.nc.adapter

import com.hg.nc.domain.UserLocationHistory
import com.hg.nc.entity.UserLocationHistoryEntity
import com.hg.nc.port.user.UserLocationHistoryPort
import com.hg.nc.repository.UserLocationHistoryRepository
import org.springframework.stereotype.Component

@Component
class UserLocationHistoryAdapter(
    private val userLocationHistoryRepository: UserLocationHistoryRepository
): UserLocationHistoryPort {
    override fun save(userLocationHistory: UserLocationHistory) {
        userLocationHistoryRepository.save(UserLocationHistoryEntity.of(userLocationHistory))
    }
}
