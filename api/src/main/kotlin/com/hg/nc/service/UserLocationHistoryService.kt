package com.hg.nc.service

import com.hg.nc.adapter.UserLocationHistoryAdapter
import com.hg.nc.controller.data.UserLocatioHistorySaveRequest
import com.hg.nc.domain.UserLocationHistory
import org.springframework.stereotype.Service

@Service
class UserLocationHistoryService(
    val userLocationHistoryAdapter: UserLocationHistoryAdapter
) {

    fun saveUserLocationHistory(
        request: UserLocatioHistorySaveRequest
    ) {
        userLocationHistoryAdapter.saveUserLocationHistory(
            UserLocationHistory(
                userId = request.userId,
                latitude = request.latitude,
                longitude = request.longitude
            )
        )
    }
}
