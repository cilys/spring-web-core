package com.cilys.web.core.listener;

import com.cilys.web.core.service.RedisService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2024/11/20.
 */
@Component
@Order(1)
public class StartListener implements ApplicationListener<ApplicationReadyEvent> {

    @Resource
    RedisService redisService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("程序被启动..");
        redisService.init();
    }
}
