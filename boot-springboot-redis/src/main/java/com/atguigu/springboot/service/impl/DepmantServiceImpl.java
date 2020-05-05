package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.domain.DepmantInfoDo;
import com.atguigu.springboot.repository.DepmantDao;
import com.atguigu.springboot.service.DepmantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author sunbaojin
 * @date 2020/5/4 9:31
 */
@Service
public class DepmantServiceImpl implements DepmantService {

    @Autowired
    DepmantDao depmantDao;

    @Override
    public DepmantInfoDo findById(Long id) {
        Optional<DepmantInfoDo> byId = depmantDao.findById(id);
        return byId.orElse(null);
    }
}
