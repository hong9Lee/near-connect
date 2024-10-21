package com.hg.nc.entity

import com.hg.nc.domain.Users
import jakarta.persistence.*
import org.apache.catalina.User
import java.time.ZonedDateTime

@Entity
@Table(name = "user")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false, updatable = false)
    val seq: Long? = null,

    @Column(name = "user_id")
    val userId: String,

    @Column(name = "user_name")
    val userName: String,

    @Column(name = "reg_date_time", nullable = false, updatable = false)
    private var regDateTime: ZonedDateTime? = ZonedDateTime.now(),
) {
    companion object {
        fun of(users: Users): UserEntity {
            return UserEntity(
                userId = users.userId,
                userName = users.userName
            )
        }
    }

    fun toDomain(): Users {
        return Users(
            userId = this.userId,
            userName = this.userName
        )
    }
}
