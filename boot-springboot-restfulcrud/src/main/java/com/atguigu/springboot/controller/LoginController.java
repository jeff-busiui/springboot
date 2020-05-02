package com.atguigu.springboot.controller;

import com.atguigu.springboot.exception.UserNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author sunbaojin
 * @date 2020/5/2 13:56
 */
@Controller
@Slf4j
public class LoginController {

    @PostMapping(value = "/userlogin")
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password,
                            Map<String, Object> loginMap, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            // 设置session
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } else {
            loginMap.put("msg", "登陆失败了");
            log.info("========" + loginMap);
            return "login";
        }
    }

    @GetMapping("/getUser")
    @ResponseBody
    public String getUser(@RequestParam("username") String username){
        // 如果是aaa，抛出异常
        if("aaa".equals(username)){
            throw  new UserNotExistException();
        }
        return "你好，"+username;
    }
}
