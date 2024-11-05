package com.hg.nc.controller.data

import java.math.BigDecimal

data class SessionInitializationRequest(
    val userId: String,
    val latitude: BigDecimal,
    val longitude: BigDecimal
)
