package cn.org.bugcreator.dao;

import cn.org.bugcreator.entity.UserEntity;
import cn.org.bugcreator.vo.UserFriendsVo;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserFriendMapper extends BaseMapper<UserEntity> {
    List<UserEntity> getUserFriendsById(Integer id);
}
