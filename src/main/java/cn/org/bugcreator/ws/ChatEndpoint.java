package cn.org.bugcreator.ws;

import cn.hutool.json.JSONUtil;
import cn.org.bugcreator.configuartion.GetHttpSessionConfig;
import cn.org.bugcreator.vo.Message;
import cn.org.bugcreator.wsutil.MessageUtils;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Chat WebSocket Endpoint.
 *
 * @author aiden
 * @data 11/06/2024
 * @description Handles WebSocket connections for a chat application.
 */

@ServerEndpoint(value = "/chat", configurator = GetHttpSessionConfig.class)
public class ChatEndpoint {

    private static final Map<String, Session> onlineUsers = new ConcurrentHashMap<>();

    private HttpSession httpSession;

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        String userName = (String) this.httpSession.getAttribute("user");
        onlineUsers.put(userName, session);
        String jsonObj = MessageUtils.getMessage(true, null, getFriends(userName));
        broadcastAllUser(jsonObj);
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        Message msg = JSONUtil.toBean(message, Message.class);
        String toName = msg.getToName();
        String messageToSend = msg.getMessage();
        Session targetSession = onlineUsers.get(toName);
        String userName = (String) this.httpSession.getAttribute("user");
        try {
            targetSession.getBasicRemote().sendText(MessageUtils.getMessage(false, userName, messageToSend));
        } catch (Exception e) {

        }
    }

    /**
     * find current user's friends
     *
     * @param userName
     * @return
     */
    public Set<String> getFriends(String userName) {
        Set<String> friends = new HashSet<>();
        for (String user : onlineUsers.keySet()) {
            if (!user.equals(userName)) {
                friends.add(user);
            }
        }
        return friends;
    }

    private void broadcastAllUser(String message) {
        onlineUsers.values().forEach(session -> {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        String userName = (String) this.httpSession.getAttribute("user");
        onlineUsers.remove(userName);
        String jsonObj = MessageUtils.getMessage(true, null, getFriends(userName));
        broadcastAllUser(jsonObj);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }
}
