package com.supcon.websocket;

import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;


@ServerEndpoint(value = "/ws/alarm")
@Component
public class AlarmSocket {

    private static AtomicInteger onlineCount = new AtomicInteger(0);


    private static CopyOnWriteArraySet<AlarmSocket> webSocketSet = new CopyOnWriteArraySet<AlarmSocket>();


    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        session.getBasicRemote().sendText(message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    public static void pushData(String data) {
        for (AlarmSocket item : webSocketSet) {
            try {
                item.sendMessage(data);
            } catch (IOException e) {
                continue;
            }
        }
    }


    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public void sendMessageBySession(Session session, String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }


    public static  int getOnlineCount() {
        return onlineCount.get();
    }

    public static  void addOnlineCount() {
        onlineCount.incrementAndGet();
    }

    public static  void subOnlineCount() {
        onlineCount.decrementAndGet();
    }
}
