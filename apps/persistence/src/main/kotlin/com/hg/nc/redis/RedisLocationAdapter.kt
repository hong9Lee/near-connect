package com.hg.nc.redis

import com.hg.nc.port.RedisLocationCachePort
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class RedisLocationAdapter(
    private val redisTemplate: RedisTemplate<String, String>
): RedisLocationCachePort {
    override fun saveLocation(userId: String, latitude: Double, longitude: Double) {
        val key = "location:$userId"
        val value = "$latitude,$longitude"
        redisTemplate.opsForValue().set(key, value, 300, TimeUnit.SECONDS)
    }
}
