package com.example.securityweb.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(auths -> auths
                        .antMatchers("/admin/**").hasRole("ADMIN")   // 設定只有ROLE_ADMIN權限能訪問的路徑
                        .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")// 設定有ROLE_ADMIN or ROLE_USER權限能訪問的路徑
                        .antMatchers("/", "/home", "/login").permitAll()) // 設定所有人可訪問的路徑
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll())  // 設定login路徑
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/") // 在這裡設置登出後的重導向頁面
                        .permitAll()) // 設定logout路徑
                .exceptionHandling(exception -> exception
                        .accessDeniedHandler(accessDeniedHandler())); // 設定無權限時的顯示頁面
        return http.build();
    }
    // 設定無權限時對應controller的路徑
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> {
            response.sendRedirect("/access-denied");
        };
    }
    // 設定編碼器，目前密碼無加密
    @Bean
    public PasswordEncoder passwordEncoder() {
        // 這個編碼器支持多種編碼方式，包括明文（添加{noop}前綴）
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
