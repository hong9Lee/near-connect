package com.hg.nc.entity

import com.hg.nc.support.BooleanYnConverter
import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(
    name = "follow_relationship",
    uniqueConstraints = [UniqueConstraint(name = "unique_follower_followed", columnNames = ["follower_id", "followed_id"])]
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
)
