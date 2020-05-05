package com.atguigu.springboot.controller;

import com.atguigu.springboot.domain.DepmantInfoDo;
import com.atguigu.springboot.service.DepmantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunbaojin
 * @date 2020/5/4 9:32
 */
@RestController
@CacheConfig(cacheNames = {"my_dep"})
public class DepmantController {

    @Autowired
    private  DepmantService depmantService;

    @GetMapping("/dep/getDep/{id}")
    @Cacheable(value="findById",keyGenerator = "myKeyGenerator")
    public DepmantInfoDo findById(@PathVariable("id") Long id){
        return depmantService.findById(id);
    }

}
