package com.hg.nc.port.redis

interface RedisLocationSubscriber {
    fun handleMessage(message: String)
}