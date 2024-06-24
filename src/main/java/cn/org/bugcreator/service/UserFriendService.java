package cn.org.bugcreator.service;

import cn.org.bugcreator.dto.CommonResponse;
import cn.org.bugcreator.entity.UserEntity;
import cn.org.bugcreator.entity.UserFriendEntity;
import cn.org.bugcreator.vo.UserFriendsVo;

import java.util.List;

public interface UserFriendService {

    CommonResponse<List<UserEntity>> selectUserFriendsByUserId(Integer userId);
}
