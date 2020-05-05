package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.domain.UserInfoDo;
import com.atguigu.springboot.repository.UserInfoDao;
import com.atguigu.springboot.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author sunbaojin
 * @date 2020/5/3 21:58
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfoDo findById(Long id) {
        Optional<UserInfoDo> byId = userInfoDao.findById(id);
        UserInfoDo userInfoDo = byId.orElse(null);
        return userInfoDo;
    }

    @Override
    public UserInfoDo insertUser(UserInfoDo userInfoDo) {
        userInfoDo = userInfoDao.save(userInfoDo);
        return userInfoDo;
    }

    @Override
    public int deleteById(Long id) {
        userInfoDao.deleteById(id);
        return 1;
    }

    @Override
    public UserInfoDo updateUser(UserInfoDo userInfoDo) {
        userInfoDo = userInfoDao.save(userInfoDo);
        return userInfoDo;
    }
}
