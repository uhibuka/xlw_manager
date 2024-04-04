package cn.xlw.controller;

import cn.xlw.entity.ResponseResult;
import cn.xlw.entity.User;
import cn.xlw.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Create by xlw on 2024/4/4 15:38
 */
@RestController
public class LoginController {

    @Resource
    LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        return loginService.login(user);
    }

}
