package com.example.securityweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);
    //預設的首頁 所有用戶皆可拜訪
    @GetMapping("/")
    public String home() {
        return "home";
    }
    //登入頁面
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    // 使用者可訪問的頁面
    @GetMapping("/user")
    public String user(Principal principal) {
        // 以下是用來觀察登入後 spring security記錄在session的登入資訊
        UsernamePasswordAuthenticationToken user = (UsernamePasswordAuthenticationToken) principal;
        log.info("登入資訊 :{}",user);
        log.info("登入資訊name :{}", user.getName());
        log.info("登入資訊credentials :{}", user.getCredentials());
        log.info("登入資訊principal :{}", user.getPrincipal());
        User userPrincipal = (User)user.getPrincipal();
        log.info("UserPrincipal 授權的ROLE :{}" , userPrincipal.getAuthorities());
        log.info("UserPrincipal 帳號 :{}" , userPrincipal.getUsername());
        log.info("UserPrincipal 密碼 :{}" , userPrincipal.getPassword());


        return "user";
    }
    // 管理者可訪問的頁面
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
    //禁止訪問的頁面
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "accessDenied";
    }
}
