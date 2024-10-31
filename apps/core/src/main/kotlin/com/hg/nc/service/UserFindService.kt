package com.hg.nc.service

import com.hg.nc.port.user.UserPort
import org.springframework.stereotype.Service

@Service
class UserFindService(
    private val userPort: UserPort
) {

    fun findUser(userId: String): Boolean {
        return userPort.isUserExists(userId) != null
    }
}
