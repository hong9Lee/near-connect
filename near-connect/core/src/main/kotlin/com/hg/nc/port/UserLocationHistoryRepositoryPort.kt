package com.hg.nc.port

import com.hg.nc.domain.UserLocationHistory

interface UserLocationHistoryRepositoryPort {
    fun save(userLocationHistory: UserLocationHistory)
}
