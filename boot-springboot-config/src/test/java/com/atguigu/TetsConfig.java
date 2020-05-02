package com.atguigu;

import com.atguigu.springboot.bo.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sunbaojin
 * @date 2020/5/1 6:45
 */
@Slf4j
@SpringBootApplication
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
public class TetsConfig {

    @Autowired
    private Person person ;

    @Value("${spring.profiles.active}")
    private String profilesActive;

    @Test
    public void testCongi1(){
        log.info(person.getName());
        log.info(person.toString());
        log.info(profilesActive);
    }
}
