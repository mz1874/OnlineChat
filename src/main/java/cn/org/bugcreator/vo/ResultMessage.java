package cn.org.bugcreator.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author aiden
 * @data 11/06/2024
 * @description
 */
@Data
public class ResultMessage implements Serializable {

    private boolean isSystem;

    private Object message;

    private String fromName;
}
