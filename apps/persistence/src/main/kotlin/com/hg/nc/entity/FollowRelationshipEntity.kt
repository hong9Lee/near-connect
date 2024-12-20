package com.hg.nc.entity

import com.hg.nc.domain.FollowRelationship
import com.hg.nc.supports.BooleanYnConverter
import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(
    name = "follow_relationship",
    uniqueConstraints = [UniqueConstraint(
        name = "unique_follower_followed",
        columnNames = ["follower_id", "followed_id"]
    )]
)
class FollowRelationshipEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false, updatable = false)
    val seq: Long? = null,

    @Column(name = "follower_id", nullable = false, length = 64)
    val followerId: String,

    @Column(name = "followed_id", nullable = false, length = 64)
    val followedId: String,

    @Column(name = "event_date_time", nullable = false, updatable = false)
    var eventDateTime: ZonedDateTime = ZonedDateTime.now(),

    @Column(name = "active_yn", nullable = false, columnDefinition = "CHAR(1)")
    @Convert(converter = BooleanYnConverter::class)
    private var isActive: Boolean = false
) {
    companion object {
        fun of(domain: FollowRelationship): FollowRelationshipEntity {
            return FollowRelationshipEntity(
                seq = domain.seq,
                followerId = domain.followerId,
                followedId = domain.followedId,
                eventDateTime = domain.eventDateTime ?: ZonedDateTime.now(),
                isActive = domain.isActive
            )
        }
    }

    fun toDomain(): FollowRelationship {
        return FollowRelationship(
            seq = this.seq,
            followerId = this.followerId,
            followedId = this.followedId,
            eventDateTime = this.eventDateTime,
            isActive = this.isActive
        )
    }
}
