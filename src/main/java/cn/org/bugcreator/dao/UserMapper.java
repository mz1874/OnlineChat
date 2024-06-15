package cn.org.bugcreator.dao;

import cn.org.bugcreator.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    UserEntity selectUserByUserNameAndPassword(String userName, String passWord);

}
