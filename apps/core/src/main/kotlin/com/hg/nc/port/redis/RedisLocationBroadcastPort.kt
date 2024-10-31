package com.hg.nc.port.redis

interface RedisLocationBroadcastPort {
    fun broadcastLocationUpdate(userId: String, message: String)
}
