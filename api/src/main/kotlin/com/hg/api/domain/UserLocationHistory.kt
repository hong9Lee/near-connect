package com.hg.api.domain

import java.math.BigDecimal

data class UserLocationHistory(
    val userId: String,
    val latitude: BigDecimal,
    val longitude: BigDecimal
)
