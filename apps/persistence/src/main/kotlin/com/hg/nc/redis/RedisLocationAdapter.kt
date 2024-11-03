package com.hg.nc.redis

import com.hg.nc.port.redis.RedisLocationCachePort
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class RedisLocationAdapter(
    private val redisTemplate: RedisTemplate<String, String>
) : RedisLocationCachePort {
    override fun saveLocation(userId: String, latitude: Double, longitude: Double) {
        val key = "location:$userId"
        val value = "$latitude,$longitude"
        redisTemplate.opsForValue().set(key, value, 300, TimeUnit.SECONDS)
    }

    override fun getLocationsByUserIds(userIds: Set<String>): Map<String, String> {
        val locationKeys = userIds.map { "user:location:$it" }
        val locations = redisTemplate.opsForValue().multiGet(locationKeys)

        return userIds.zip(locations ?: listOf()).filter { it.second != null }.associate {
            it.first to it.second!!
        }
    }
}
