package com.hg.nc.domain

import java.math.BigDecimal

data class UserLocationHistory(
    val userId: String,
    val latitude: BigDecimal,
    val longitude: BigDecimal
)
