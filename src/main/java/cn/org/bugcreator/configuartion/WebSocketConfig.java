package cn.org.bugcreator.configuartion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author aiden
 * @data 11/06/2024
 * @description
 */
@Configuration
public class WebSocketConfig {

    public ServerEndpointExporter serverEndpointExporter()
    {
        return new ServerEndpointExporter();
    }
}
