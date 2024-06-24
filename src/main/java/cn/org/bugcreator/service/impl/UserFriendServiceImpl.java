package cn.org.bugcreator.service.impl;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import cn.org.bugcreator.dao.UserFriendMapper;
import cn.org.bugcreator.dto.CommonResponse;
import cn.org.bugcreator.entity.UserEntity;
import cn.org.bugcreator.service.UserFriendService;
import cn.org.bugcreator.vo.UserFriendsVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFriendServiceImpl implements UserFriendService {

    @Resource
    private UserFriendMapper userFriendMapper;
    @Override
    public CommonResponse<List<UserEntity>> selectUserFriendsByUserId(Integer userId) {
        List<UserEntity> result  = userFriendMapper.getUserFriendsById(userId);
        if (null == result){
            return CommonResponse.success(null);
        }
        return CommonResponse.success(result);
    }
}
