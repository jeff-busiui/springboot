package com.atguigu.springboot.config;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author sunbaojin
 * @date 2020/5/4 0:32
 */
@Configuration
@Slf4j
public class MykeyGenerator {

    @Bean(name="myKeyGenerator")
    public KeyGenerator myKeyGenerator(){
        return new KeyGenerator(){
            @Override
            public Object generate(Object target, Method method, Object... params) {
//                对称加密
//                SecureUtil.aes
//                SecureUtil.des
//                SecureUtil.aes().decryptStr();
                String s1 = JSONUtil.toJsonStr(params);
                log.info(s1);
                // MD5加密
                String s = SecureUtil.md5(s1);
                String className = target.getClass().getSimpleName();
                String methodName = method.getName();
                // 获取key的所有参数
                return className+"_"+ methodName+"_"+ s;
            }
        };
    }
}
