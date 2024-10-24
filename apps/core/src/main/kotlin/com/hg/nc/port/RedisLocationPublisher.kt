package com.hg.nc.port

interface RedisLocationPublisher {
    fun publishLocationUpdate(userId: String, latitude: Double, longitude: Double)
}
