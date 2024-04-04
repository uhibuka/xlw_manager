package cn.xlw.service.impl;

import cn.xlw.entity.LoginUser;
import cn.xlw.entity.ResponseResult;
import cn.xlw.entity.User;
import cn.xlw.service.LoginService;
import cn.xlw.util.JwtUtil;
import cn.xlw.util.RedisCache;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Create by xlw on 2024/4/4 15:41
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    AuthenticationManager authenticationManager;
    @Resource
    RedisCache redisCache;


    @Override
    public ResponseResult login(User user) {
        //3使用ProviderManager auth方法进行验证
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //校验失败了
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误！");
        }

        //4自己生成jwt给前端
        LoginUser loginUser = (LoginUser) (authenticate.getPrincipal());
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        Map<String, String> map = new HashMap();
        map.put("token", jwt);
        //5系统用户相关所有信息放入redis
        redisCache.setCacheObject("login:" + userId, loginUser);
        return new ResponseResult(200, "登陆成功", map);
    }
}
