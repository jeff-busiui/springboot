package com.atguigu.springboot.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author sunbaojin
 * @date 2020/5/2 13:18
 */
@Slf4j
public class MyLocalComponent implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取参数
        String l = request.getParameter("l");
        // 获取request默认的语言
        Locale locale = request.getLocale();
        if(!StringUtils.isEmpty(l)){
            // 获取参数
            String[] s = l.split("_");
            locale = new Locale(s[0], s[1]);
            log.info("============"+locale);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
