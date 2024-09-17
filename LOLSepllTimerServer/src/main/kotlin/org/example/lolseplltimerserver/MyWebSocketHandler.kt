package org.example.lolseplltimerserver

import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.util.*

@Component
object MyWebSocketHandler : TextWebSocketHandler() {

    val sessions: MutableSet<WebSocketSession> = Collections.synchronizedSet(mutableSetOf())

    override fun afterConnectionEstablished(session: WebSocketSession) {
        sessions.add(session)
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        // sessions.filter { it.isOpen }.forEach { it.sendMessage(message) }
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        sessions.remove(session)
    }
}
