package com.hg.nc.adapter

import com.hg.nc.port.websocket.WebSocketInitializationPort
import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter
import org.springframework.stereotype.Component
import org.springframework.web.socket.client.standard.StandardWebSocketClient
import org.springframework.web.socket.messaging.WebSocketStompClient

@Component
class WebSocketInitializationAdapter: WebSocketInitializationPort {

    private val stompClient: WebSocketStompClient = WebSocketStompClient(StandardWebSocketClient())
    private lateinit var stompSession: StompSession


    init {
        connectToWebSocketServer()
    }

    private fun connectToWebSocketServer() {
        try {
            val url = "ws://localhost:8080/ws"
            stompSession = stompClient.connect(url, object : StompSessionHandlerAdapter() {}).get()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun initializeSession(userId: String, friendIds: Set<String>, friendLocations: Map<String, String>) {
        friendIds.forEach { friendId ->
            subscribeToFriendChannel(friendId)
        }
    }

    private fun subscribeToFriendChannel(friendId: String) {
        val topic = "/sub/user/$friendId/location"
        stompSession.subscribe(topic, object : StompSessionHandlerAdapter() {
            override fun handleFrame(headers: StompHeaders, payload: Any?) {
                println("Received location update from $friendId: $payload")
            }
        })
    }
}
