package com.hg.api.controller.data

import java.math.BigDecimal

data class UserLocationRequest(
    val id: Long,
    val userId: String,
    val latitude: BigDecimal,
    val longitude: BigDecimal
)
