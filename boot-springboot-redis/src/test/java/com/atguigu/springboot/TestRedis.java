package com.atguigu.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sunbaojin
 * @date 2020/5/3 22:18
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRedis {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Test
    public void addString(){
        redisTemplate.opsForValue().set("t2","t1333_value");
        redisTemplate.opsForHash().put("user","u1","u1_value");
        redisTemplate.opsForHash().put("user","u2","u1_value");
    }

    @Test
    public void getString(){
        redisTemplate.opsForValue().get("t1");
    }
}
