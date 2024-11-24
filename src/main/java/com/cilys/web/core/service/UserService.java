package com.cilys.web.core.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2024/11/21.
 */
@Service
public class UserService extends RedisService {

    public void login(String userName, String pwd) {
        Map map = get("sys_user", "userName", userName);
        logger.info("验证登录..", map);
    }


}
