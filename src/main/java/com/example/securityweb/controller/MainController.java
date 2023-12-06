package com.example.securityweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
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
    public String user() {
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
