package com.atguigu.springboot.config;

import com.atguigu.springboot.component.MyLocalComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sunbaojin
 * @date 2020/5/2 12:00
 */
@Configuration
@Slf4j
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/testMyMvc").setViewName("success");
    }


    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurerObj = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                // 重定向到dababash页面
                registry.addViewController("/main.html").setViewName("databash");
            }

            // 增加自定义拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
//                        excludePathPatterns("/","/login.html","/userlogin");
//            }
        };

        return webMvcConfigurerObj;
    }

    @Bean
    public LocaleResolver localeResolver(){
        log.info("==========我的国际化");
        return new MyLocalComponent();
    }
}
