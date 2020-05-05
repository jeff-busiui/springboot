package com.atguigu.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunbaojin
 * @date 2020/5/5 8:43
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(MyAutoProperties.class)
public class MyAutoConfiguration {
    @Autowired
    private MyAutoProperties myAutoProperties;

    @Bean
    public MyAutoServiceTemplate getMyAutoServiceTemplate(){
        MyAutoServiceTemplate myAutoServiceTemplate = new MyAutoServiceTemplate();
        myAutoServiceTemplate.setMyAutoProperties(myAutoProperties);

        return myAutoServiceTemplate;
    }
}
