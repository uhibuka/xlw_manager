package cn.xlw.controller;

import cn.xlw.entity.User;
import cn.xlw.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Create by xlw on 2024/4/4 13:32
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping()
    public ResponseEntity<User> queryById(Integer id){
        return ResponseEntity.ok(this.userService.queryById(id));
    }

}
