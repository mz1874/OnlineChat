package cn.org.bugcreator.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserVo {

    private Integer id;

    private String name;

    private String address;

    private String tel;

    private boolean gender;

    private Date createDate;

    private String session;
}
