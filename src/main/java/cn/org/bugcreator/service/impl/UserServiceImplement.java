package cn.org.bugcreator.service.impl;

import cn.org.bugcreator.dao.UserMapper;
import cn.org.bugcreator.dto.CommonResponse;
import cn.org.bugcreator.entity.UserEntity;
import cn.org.bugcreator.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImplement implements UserService {


    @Resource
    private UserMapper userMapper;

    @Override
    public CommonResponse login(String userName, String password) {
        if (null != userName && null != password){
            UserEntity result = userMapper.selectUserByUserNameAndPassword(userName, password);

            return CommonResponse.success(result);
        }
        return CommonResponse.success("Could not find the userName or password");
    }

    @Override
    public CommonResponse<String> register(UserEntity user) {
        if (user.getName() == null || user.getUserPassword() == null){
            return CommonResponse.failure("userName or password must not be null");
        }
        userMapper.insert(user);
        return CommonResponse.success("install successful!");
    }
}
