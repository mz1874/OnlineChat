package cn.org.bugcreator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author aiden
 * @data 11/06/2024
 * @description
 */
@Data
@TableName("tb_user")
public class UserEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String userPassword;

    private String address;

    private String tel;

    private boolean gender;

    private Date createDate;


}
