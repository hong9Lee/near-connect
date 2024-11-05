package com.hg.nc.port.websocket

interface WebSocketInitializationPort {
    fun initializeSession(userId: String, friendIds: Set<String>, friendLocations: Map<String, String>)
}
