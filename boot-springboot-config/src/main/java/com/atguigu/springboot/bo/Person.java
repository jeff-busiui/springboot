package com.atguigu.springboot.bo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author sunbaojin
 * @date 2020/5/2 11:08
 */
@Component
@ConfigurationProperties(prefix = "person", ignoreUnknownFields = true)
@Data
public class Person {
    private  String name;
    private  Long age;
    private Map<String,String> dataMap;
}
