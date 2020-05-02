package com.atguigu.springboot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunbaojin
 * @date 2020/5/2 14:38
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取session的登陆用户
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(StringUtils.isEmpty(loginUser)){
            // 设置返回参数
            request.setAttribute("msg","你没权限");
            // 未登录
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }
        else{
            // 已登陆
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
