package cn.org.bugcreator.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.org.bugcreator.dto.CommonResponse;
import cn.org.bugcreator.entity.UserEntity;
import cn.org.bugcreator.service.UserFriendService;
import cn.org.bugcreator.service.UserService;
import cn.org.bugcreator.vo.UserFriendsVo;
import cn.org.bugcreator.vo.UserVo;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author aiden
 * @data 11/06/2024
 * @description
 */

@RestController
@RequestMapping(value = "userFriend")
public class UserFriendsController {


    @Resource
    private UserFriendService userFriendService;



    @GetMapping(value = "selectUserFriendsByUserId")
    public CommonResponse<List<UserEntity>> selectUserFriendsByUserId(HttpSession session) {
        UserVo user = (UserVo)  session.getAttribute("user");
        if (user== null){
            return CommonResponse.failure("Please login first");
        }
        return userFriendService.selectUserFriendsByUserId(user.getId());
    }
}




