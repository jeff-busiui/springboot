package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sunbaojin
 * @date 2020/5/3 21:49
 */
@SpringBootApplication
@EnableCaching  // 需要这个注解才能启用注解驱动的缓存管理功能
@EnableSwagger2
public class RedisMain {
    public static void main(String[] args) {
            SpringApplication.run(RedisMain.class,args);
    }
}
