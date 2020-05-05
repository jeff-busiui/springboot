package com.atguigu.springboot.controler;

import com.atguigu.starter.MyAutoServiceTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunbaojin
 * @date 2020/5/5 9:10
 */
@RestController
@Slf4j
public class TestMystarterController {

    @Autowired
    private MyAutoServiceTemplate myAutoServiceTemplate;

    @GetMapping("/mystarter/testMystarter")
    public String testMystarter(){
        String mySay = myAutoServiceTemplate.sayHello("张三");
        log.info(mySay);
        return mySay;
    }
}
