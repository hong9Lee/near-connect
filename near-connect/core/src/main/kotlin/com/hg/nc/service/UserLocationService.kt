package com.hg.nc.service

import com.hg.nc.domain.UserLocationHistory
import com.hg.nc.port.UserLocationHistoryRepositoryPort
import org.springframework.stereotype.Service

@Service
class UserLocationService(
    private val userLocationHistoryRepositoryPort: UserLocationHistoryRepositoryPort
) {
    fun saveLocation(userId: String, latitude: Double, longitude: Double) {
        userLocationHistoryRepositoryPort.save(
            UserLocationHistory(
                userId = userId,
                latitude = latitude,
                longitude = longitude
            )
        )
    }
}
