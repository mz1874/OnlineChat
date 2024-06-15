package cn.org.bugcreator.ws;

import cn.hutool.json.JSONUtil;
import cn.org.bugcreator.configuartion.GetHttpSessionConfig;
import cn.org.bugcreator.util.LogUtil;
import cn.org.bugcreator.vo.Message;
import cn.org.bugcreator.wsutil.MessageUtils;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

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

@ServerEndpoint("/socket/{userName}")
@Component
public class ChatEndpoint {


    private static final Map<String, Session> onlineUsers = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, EndpointConfig config, @PathParam("userName") String userName) {
        LogUtil.logInfo(ChatEndpoint.class,"WS\r" + userName + "\tConnected!");
        onlineUsers.put(userName, session);
        String jsonObj = MessageUtils.getMessage(true, null, getFriends(userName));
        broadcastAllUser(jsonObj);
    }

    @OnMessage
    public void onMessage(Session session, String message, @PathParam("userName") String userName) {
        Message msg = JSONUtil.toBean(message, Message.class);
        String toName = msg.getToName();
        String messageToSend = msg.getMessage();
        Session targetSession = onlineUsers.get(toName);
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
    public void onClose(Session session, CloseReason closeReason, @PathParam("userName") String userName) {
        onlineUsers.remove(userName);
        String jsonObj = MessageUtils.getMessage(true, null, getFriends(userName));
        broadcastAllUser(jsonObj);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }
}
