package com.hg.api.service

import com.hg.api.adapter.UserLocationHistoryAdapter
import com.hg.api.controller.data.UserLocationRequest
import com.hg.api.domain.UserLocationHistory
import org.springframework.stereotype.Service

@Service
class UserLocationHistoryService(
    val userLocationHistoryAdapter: UserLocationHistoryAdapter
) {

    fun saveUserLocationHistory(
        request: UserLocationRequest
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
