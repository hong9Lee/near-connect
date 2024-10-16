package com.hg.nc.model

import java.math.BigDecimal

data class UserLocationPubRequest(
    val userId: String,
    val latitude: BigDecimal,
    val longitude: BigDecimal
)
