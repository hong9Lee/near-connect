package com.hg.api.entity

import com.hg.api.domain.UserLocationHistory
import jakarta.persistence.*
import java.math.BigDecimal
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
    val latitude: BigDecimal,

    @Column(name = "longitude")
    val longitude: BigDecimal,

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
