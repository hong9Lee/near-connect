package com.hg.nc.port.redis

interface RedisLocationCachePort {
    fun saveLocation(userId: String, latitude: Double, longitude: Double)
}