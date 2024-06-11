package cn.org.bugcreator.controller;

import cn.org.bugcreator.entity.UserEntity;
import cn.org.bugcreator.vo.CommonResult;
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


    /**
     * login
     * @param user
     * @param session
     * @return
     */
    @PostMapping(value = "login")
    public CommonResult login(@RequestBody UserEntity user, HttpSession session){
        CommonResult commonResult = new CommonResult();

        if (null != user && user.getUsername().equals("123") && user.getPassword().equals("123")){
            commonResult.setFlag(true);
            session.setAttribute("user", user.getUsername());
        }else {
            commonResult.setFlag(false);
            commonResult.setMessage("Login fail!");
        }
        return commonResult;
    }

    /**
     * get current login user name
     * @param session
     * @return
     */
    @GetMapping(value = "getUserName")
    public String getUserName(HttpSession session){
        String userName = (String)  session.getAttribute("user");
        return userName;
     }
}
