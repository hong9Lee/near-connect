package com.hg.nc.port.redis

interface RedisLocationPublisher {
    fun publishLocationUpdate(userId: String, latitude: Double, longitude: Double)
}
