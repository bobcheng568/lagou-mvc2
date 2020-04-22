package com.lagou.edu.interceptor;


import com.lagou.edu.pojo.User;
import com.lagou.edu.util.UserInfoCache;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * 自定义springmvc拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User currentUser = UserInfoCache.getCurrentUser(request);
        if (Objects.isNull(currentUser)) {
            response.sendRedirect("/login/toLogin");
            return false;
        }
        return true;
    }

}
