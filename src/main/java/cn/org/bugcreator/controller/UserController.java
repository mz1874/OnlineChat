package cn.org.bugcreator.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.org.bugcreator.dto.CommonResponse;
import cn.org.bugcreator.entity.UserEntity;
import cn.org.bugcreator.service.UserService;
import cn.org.bugcreator.vo.CommonResult;
import cn.org.bugcreator.vo.UserVo;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

/**
 * @author aiden
 * @data 11/06/2024
 * @description
 */

@RestController
@RequestMapping(value = "user")
public class UserController {


    @Resource
    private UserService userService;

    @PostMapping(value = "login")
    public CommonResponse login(@RequestBody UserEntity user, HttpSession session){

        CommonResponse login = userService.login(user.getName(), user.getUserPassword());
        if (200 == login.getCode()){
            UserVo userVo = BeanUtil.copyProperties(login.getData(), UserVo.class);
            userVo.setSession(session.getId());
            login.setData(userVo);
            session.setAttribute("user", userVo);
            return login;
        }
        return login;
    }

    /**
     * get current login user name
     * @param session
     * @return
     */
    @GetMapping(value = "getUserName")
    public String getUserName(HttpSession session){
        UserVo userName = (UserVo)  session.getAttribute("user");
        return userName.getName();
     }
}
