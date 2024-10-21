package com.hg.nc.config

import com.hg.nc.service.UserFindService
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.stereotype.Component
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.server.HandshakeInterceptor
import java.lang.Exception

@Component
class UserValidationInterceptor(
    private val userFindService: UserFindService
): HandshakeInterceptor {

    override fun beforeHandshake(
        request: ServerHttpRequest,
        response: ServerHttpResponse,
        wsHandler: WebSocketHandler,
        attributes: MutableMap<String, Any>
    ): Boolean {
        val userId = extractUserId(request)

        if (checkValidUser(userId)) {
            // 유효하지 않은 경우 연결 거부
            response.setStatusCode(org.springframework.http.HttpStatus.UNAUTHORIZED)
            return false
        }

        attributes["userId"] = userId!! // websocket 메시지 핸들러, 컨트롤러에서 사용할 수 있다.
        return true
    }

    private fun extractUserId(request: ServerHttpRequest): String? {
        return request.uri.query?.substringAfter("userId=")
            ?: request.headers.getFirst("userId")
    }
    private fun checkValidUser(userId: String?) =
        userId.isNullOrEmpty() || !isValidUser(userId) || !userFindService.findUser(userId)
    private fun isValidUser(userId: String): Boolean {
        // TODO("id 패턴 검증에 사용하면 좋을것 같음.")
        return true
    }

    override fun afterHandshake(
        request: ServerHttpRequest,
        response: ServerHttpResponse,
        wsHandler: WebSocketHandler,
        exception: Exception?
    ) {
        // TODO("Not yet implemented")
    }
}
