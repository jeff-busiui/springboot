package com.atguigu.controller;

import com.atguigu.domain.UserInfoDo;
import com.atguigu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunbaojin
 * @date 2020/5/3 20:02
 */
@RestController
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/user/getUser/{id}")
    public UserInfoDo findById(@PathVariable("id") Long id){
        return userInfoService.findById(id);
    }
}
