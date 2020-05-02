package com.atguigu.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author sunbaojin
 * @date 2020/5/2 22:19
 */
@ControllerAdvice
public class MyExceptionHander {

    /**
     * 自定义捕获的异常类
     * @param e
     * @return
     */
    @ExceptionHandler(UserNotExistException.class)
    public String handerException(Exception e, HttpServletRequest request){
        // 异常信息
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        // 设置code码
        /**
         * 源码：
         * AbstractErrorController
         * Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
         * 备注：状态码 必须再 HttpStatus 存在，否则会出现500错误
         */
        request.setAttribute("javax.servlet.error.status_code",429);
        objectObjectHashMap.put("code","u40");
        objectObjectHashMap.put("mag","用户去哪了？");
        request.setAttribute("userEx",objectObjectHashMap);
        return "forward:/error";
    }
}
