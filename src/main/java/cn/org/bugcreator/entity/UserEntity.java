package cn.org.bugcreator.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author aiden
 * @data 11/06/2024
 * @description
 */
@Data
public class UserEntity implements Serializable {

    private Integer id;

    private String name;

    private String userPassword;

    private String address;

    private String tel;

    private boolean gender;

    private Date createDate;


}
