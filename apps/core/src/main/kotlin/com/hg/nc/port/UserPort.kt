package com.hg.nc.port

import com.hg.nc.domain.Users

interface UserPort {
    fun isUserExists(userId: String): Users?
}
