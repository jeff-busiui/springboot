package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @author sunbaojin
 * @date 2020/5/1 9:06
 */
@Controller
public class TestCrudController {

    @GetMapping("/resuful/success")
    public  String getSuccess(Map<String,String> hsmap){
        hsmap.put("h1","wo shi  h1");
        return "success";
    }
}
