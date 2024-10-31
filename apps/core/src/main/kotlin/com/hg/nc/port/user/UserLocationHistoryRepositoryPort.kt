package com.hg.nc.port.user

import com.hg.nc.domain.UserLocationHistory

interface UserLocationHistoryRepositoryPort {
    fun save(userLocationHistory: UserLocationHistory)
}
