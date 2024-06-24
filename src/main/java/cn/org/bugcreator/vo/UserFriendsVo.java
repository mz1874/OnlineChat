package cn.org.bugcreator.vo;

import cn.org.bugcreator.entity.UserEntity;
import lombok.Data;
import org.apache.catalina.User;

import java.util.List;

@Data
public class UserFriendsVo {
    private Integer id;

    private UserEntity user;

    private List<UserEntity> friends;
}
