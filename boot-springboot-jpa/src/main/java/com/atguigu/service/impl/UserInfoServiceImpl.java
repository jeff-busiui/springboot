package com.atguigu.service.impl;

import com.atguigu.domain.UserInfoDo;
import com.atguigu.repository.UserDao;
import com.atguigu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author sunbaojin
 * @date 2020/5/3 19:59
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserInfoDo findById(Long id) {
        // 获取数据
        Optional<UserInfoDo> byId = userDao.findById(id);
        UserInfoDo userInfoDo = byId.orElse(new UserInfoDo());
        return userInfoDo;
    }
}
