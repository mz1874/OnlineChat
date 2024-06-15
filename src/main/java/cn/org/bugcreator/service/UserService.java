package cn.org.bugcreator.service;

import cn.org.bugcreator.dto.CommonResponse;
import cn.org.bugcreator.entity.UserEntity;
import cn.org.bugcreator.vo.CommonResult;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;


public interface UserService {

    CommonResponse login(String userName, String password);

    CommonResponse register(UserEntity user);
}
