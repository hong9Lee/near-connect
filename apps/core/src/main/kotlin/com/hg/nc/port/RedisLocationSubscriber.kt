package com.hg.nc.port

interface RedisLocationSubscriber {
    fun handleMessage(message: String)
}
