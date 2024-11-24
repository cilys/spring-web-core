package com.cilys.web.core.service;

import com.cilys.web.core.utils.CheckUtils;
import com.cilys.web.core.utils.LogUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2024/11/20.
 */
@Service
public class RedisService<P, S> extends BaseService<P, S>{

    @Resource
    private RedisTemplate redisTemplate;

    public void init() {
        LogUtils.debug(logger, "开始加载数据到Redis..");
        List<String> list = getJdbcTemplate().queryForList("show tables", String.class);

        list = list.stream().filter(i -> i.startsWith("sys_")).collect(Collectors.toList());

        for (String table : list) {
            List<Map<String, Object>> res = getList(table);
            if (res == null || res.isEmpty()) {
                continue;
            }

            LogUtils.debug(logger, "开始加载数据表{}到Redis..", table);
            redisTemplate.opsForValue().set("sys:init:" + table, res);
            LogUtils.debug(logger, "加载成功数据表{}到Redis..", table);
        }
        LogUtils.debug(logger, "完成加载数据到Redis..");
    }

    public void setValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }


    public Map<String, Object> get(String table, String keyName, Object keyValue) {
        List<Map<String, Object>> list = getList(table, keyName, keyValue);
        return list == null ? null : (list.isEmpty() ? null : list.get(0));
    }

    public List<Map<String, Object>> getList(String table, String keyName, Object keyValue) {
        if (keyName == null || keyName.isEmpty()) {
            return null;
        }
        if (keyValue == null) {
            return null;
        }

        List<Map<String, Object>> mapList = (List<Map<String, Object>>) redisTemplate.opsForValue().get("sys:init:" + table);
        if (mapList == null) {
            return null;
        }
        List<Map<String, Object>> res = new ArrayList<>();
        for (Map<String, Object> map : mapList) {
            if (map == null) {
                continue;
            }
            for (String key : map.keySet()) {
                if (keyName.equals(key)) {
                    Object value = map.get(key);
                    if (keyValue.equals(value)) {
                        res.add(map);
                    }
                }
            }
        }
        return res;
    }
}
