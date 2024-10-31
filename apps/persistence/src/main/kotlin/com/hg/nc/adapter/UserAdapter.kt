package com.hg.nc.adapter

import com.hg.nc.domain.Users
import com.hg.nc.port.user.UserPort
import com.hg.nc.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserAdapter(
    private val userRepository: UserRepository
) : UserPort {
    override fun isUserExists(userId: String): Users? {
        val toDomain = userRepository.findByUserId(userId).toDomain()
        return toDomain
    }
}
