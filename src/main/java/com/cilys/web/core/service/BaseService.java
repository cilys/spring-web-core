package com.cilys.web.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2024/11/20.
 */
@Service
public abstract class BaseService<P, S> {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    protected JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public List<Map<String, Object>> getList(String tableName) {
        return jdbcTemplate.queryForList(String.format("select * from %s;", tableName));
    }
}
