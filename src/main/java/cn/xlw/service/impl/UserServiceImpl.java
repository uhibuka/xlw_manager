package cn.xlw.service.impl;

import cn.xlw.entity.User;
import cn.xlw.mapper.UserMapper;
import cn.xlw.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Create by xlw on 2024/4/4 13:38
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User queryById(Integer id) {
        return this.userMapper.selectById(id);

    }
}
