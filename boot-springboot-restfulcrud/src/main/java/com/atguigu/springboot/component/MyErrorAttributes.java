package com.atguigu.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author sunbaojin
 * @date 2020/5/2 22:16
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        // 增加参数值
        errorAttributes.put("company","ecomsh");
        // 获取自己的参数
        Object userEx = webRequest.getAttribute("userEx",0);
        errorAttributes.put("userEx",userEx);
        return errorAttributes;
    }
}
