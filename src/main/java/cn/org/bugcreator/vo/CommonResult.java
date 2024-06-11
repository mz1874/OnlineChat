package cn.org.bugcreator.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author aiden
 * @data 11/06/2024
 * @description
 */
@Data
public class CommonResult implements Serializable {

    private boolean flag;

    private String message;

}
