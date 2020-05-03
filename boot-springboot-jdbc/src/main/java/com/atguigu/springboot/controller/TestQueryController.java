package com.atguigu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author sunbaojin
 * @date 2020/5/3 10:10
 */
@RestController
public class TestQueryController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/query")
    private List query(@RequestParam("id") Long id){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * FROM PAYMENT where id="+id );
        return  maps;
    }
}
