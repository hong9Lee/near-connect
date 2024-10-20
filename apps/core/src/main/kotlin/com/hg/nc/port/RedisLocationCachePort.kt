package com.hg.nc.port

interface RedisLocationCachePort {
    fun saveLocation(userId: String, latitude: Double, longitude: Double)
}
