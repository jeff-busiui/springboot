package com.atguigu.service;

import com.atguigu.domain.UserInfoDo;

/**
 * @author sunbaojin
 * @date 2020/5/3 19:59
 */
public interface UserInfoService {
    public UserInfoDo findById(Long id);
}
