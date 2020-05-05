package com.atguigu.springboot.service;

import com.atguigu.springboot.domain.DepmantInfoDo;

/**
 * @author sunbaojin
 * @date 2020/5/4 9:29
 */
public interface DepmantService {
    public DepmantInfoDo findById(Long id);
}
