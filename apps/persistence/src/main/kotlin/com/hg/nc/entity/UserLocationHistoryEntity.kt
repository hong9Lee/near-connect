package com.hg.nc.entity

import com.hg.nc.domain.UserLocationHistory
import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name = "user_location_history")
class UserLocationHistoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false, updatable = false)
    val id: Long? = null,

    @Column(name = "user_id")
    val userId: String,

    @Column(name = "latitude")
    val latitude: Double,

    @Column(name = "longitude")
    val longitude: Double,

    @Column(name = "reg_date_time", nullable = false, updatable = false)
    private var regDateTime: ZonedDateTime? = null,
) {
    companion object {
        fun of(userLocationHistory: UserLocationHistory): UserLocationHistoryEntity {
            return UserLocationHistoryEntity(
                userId = userLocationHistory.userId,
                latitude = userLocationHistory.latitude,
                longitude = userLocationHistory.longitude
            )
        }
    }
}
