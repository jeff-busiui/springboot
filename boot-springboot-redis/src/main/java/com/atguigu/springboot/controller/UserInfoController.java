package com.atguigu.springboot.controller;


import com.atguigu.springboot.domain.UserInfoDo;
import com.atguigu.springboot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunbaojin
 * @date 2020/5/3 20:02
 */
@RestController
@CacheConfig(cacheNames = {"my_cacheManager"},keyGenerator = "myKeyGenerator")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/user/getUser/{id}")
    @Cacheable
    public UserInfoDo findById(@PathVariable("id") Long id){
        return userInfoService.findById(id);
    }

    @PostMapping("/user/findByUserInfo")
    @Cacheable
    public UserInfoDo findByUserInfo(@RequestBody UserInfoDo user){
        return userInfoService.findById(user.getId());
    }
}
