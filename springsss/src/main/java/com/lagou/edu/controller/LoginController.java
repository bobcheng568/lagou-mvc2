package com.lagou.edu.controller;

import com.lagou.edu.pojo.User;
import com.lagou.edu.util.UserInfoCache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {


    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/auth")
    public String login(String username, String password, HttpServletResponse response) {
        if ("admin".equals(username) && "admin".equals(password)) {
            UserInfoCache.setCurrentUser(new User(username, password), response);
            return "redirect: /resume/queryAll";
        }
        return "error";
    }

}
