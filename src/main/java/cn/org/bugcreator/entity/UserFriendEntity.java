package cn.org.bugcreator.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_user_friends")
public class UserFriendEntity {
    @TableId
    @TableField("id")
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("friend_id")
    private Integer friendId;
}
