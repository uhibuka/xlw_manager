package cn.xlw.service;

import cn.xlw.entity.ResponseResult;
import cn.xlw.entity.User;

/**
 * Create by xlw on 2024/4/4 15:39
 */
public interface LoginService {

    ResponseResult login(User user);

}
