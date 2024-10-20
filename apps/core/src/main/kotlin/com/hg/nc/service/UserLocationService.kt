package com.hg.nc.service

import com.hg.nc.domain.UserLocationHistory
import com.hg.nc.port.RedisLocationCachePort
import com.hg.nc.port.UserLocationHistoryRepositoryPort
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

private val logger = KotlinLogging.logger {}

@Service
class UserLocationService(
    private val userLocationHistoryRepositoryPort: UserLocationHistoryRepositoryPort,
    private val redisLocationCachePort: RedisLocationCachePort
) {

    @Transactional
    fun saveLocation(userId: String, latitude: Double, longitude: Double) {
        logger.info { "save location $userId, $latitude, $longitude" }

        // TODO: user 조회 후 저장 필요 (duplication check)
        userLocationHistoryRepositoryPort.save(
            UserLocationHistory(
                userId = userId,
                latitude = latitude,
                longitude = longitude
            )
        )


        try {
            redisLocationCachePort.saveLocation(userId, latitude, longitude)
        } catch (e: Exception) {
            logger.error(e) { "Failed to save location to Redis" }
            // 보상 로직: DB 롤백을 수행하거나 대체 로직 실행
            throw IllegalStateException("Redis 저장 실패로 트랜잭션 롤백")
        }

    }
}
