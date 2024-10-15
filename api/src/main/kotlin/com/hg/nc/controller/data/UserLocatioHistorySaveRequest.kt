package com.hg.nc.controller.data

import java.math.BigDecimal

data class UserLocatioHistorySaveRequest(
    val id: Long,
    val userId: String,
    val latitude: BigDecimal,
    val longitude: BigDecimal
)
