package cn.org.bugcreator.wsutil;

import cn.hutool.json.JSONUtil;
import cn.org.bugcreator.vo.ResultMessage;

import static cn.hutool.json.JSONUtil.toJsonStr;

/**
 * @author aiden
 * @data 11/06/2024
 * @description
 */
public class MessageUtils {

    public static String getMessage(boolean isSystemMessage, String fromName, Object message) {
        ResultMessage result = new ResultMessage();
        result.setSystem(isSystemMessage);
        result.setMessage(message);
        if (null != fromName){
            result.setFromName(fromName);
        }
        return JSONUtil.toJsonStr(result);
    }
}
