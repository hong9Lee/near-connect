package com.hg.nc.controller

import com.hg.nc.controller.data.SessionInitializationRequest
import com.hg.nc.service.SessionInitializationService
import com.hg.nc.supports.UrlConstants.Companion.웹소켓_세션_초기화
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SessionInitializationController(
    private val sessionInitializationService: SessionInitializationService
) {

    @GetMapping(웹소켓_세션_초기화)
    fun init(
        request: SessionInitializationRequest
    ) {
        sessionInitializationService.init(
            userId = request.userId,
            latitude = request.latitude,
            longitude = request.longitude
        )
    }
}
