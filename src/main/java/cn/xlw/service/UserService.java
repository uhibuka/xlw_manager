package cn.xlw.service;

import cn.xlw.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Create by xlw on 2024/4/4 13:37
 */
@Service
public interface UserService {
    User queryById(Integer id);
}
