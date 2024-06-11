package cn.org.bugcreator.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author aiden
 * @data 11/06/2024
 * @description
 */
@Data
public class UserEntity implements Serializable {

    private int userId;

    private String username;

    private String password;
}
