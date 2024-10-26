package com.hg.nc.port

interface RedisLocationBroadcastPort {
    fun broadcastLocationUpdate(userId: String, message: String)
}
