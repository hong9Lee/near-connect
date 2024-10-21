package com.hg.nc.repository

import com.hg.nc.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<UserEntity, Long> {
    fun findByUserId(userId: String): UserEntity
}
