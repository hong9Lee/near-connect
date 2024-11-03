package com.hg.nc.port.user

import com.hg.nc.domain.UserLocationHistory

interface UserLocationHistoryPort {
    fun save(userLocationHistory: UserLocationHistory)
}
