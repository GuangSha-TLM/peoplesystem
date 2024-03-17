package com.tlm.people.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

@ServerEndpoint(value = "/websocket")
@CrossOrigin
@Component
public class ProgressWebSocket {

    private static CopyOnWriteArrayList<Session> sessions = new CopyOnWriteArrayList<>();

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        System.out.println("Client connected. Session id: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        // 不需要处理客户端发送的消息
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        System.out.println("Connection closed. Session id: " + session.getId());
    }

    public static void sendProgressUpdate(double progress) {
        String message = String.valueOf(progress);
        for (Session session : sessions) {
            if (session.isOpen()) {
                try {
                    session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 添加一个静态方法，用于关闭所有连接
    public static void closeAllSessions() {
        for (Session session : sessions) {
            try {
                session.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        sessions.clear();
    }

}
