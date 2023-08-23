package com.example.springbootstudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security 配置文件
 *
 * @Configuration 表示是一个配置文件
 *
 * 旧版SpringSecurity需要使用继承WebSecurityConfigurerAdapter来实现安全配置
 * 当前版本已经启用WebSecurityConfigurerAdapter，无需再继承
 * 编写一个SecurityFilterChain的方法，以HttpSecurity作为参数
 * 然后在方法里面对HttpSecurity进行配置
 */
@Configuration
public class SecurityConfig {

    /**
     * 当前配置是对于所有路由的所有请求放行
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return  httpSecurity.authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .csrf()
                .disable()
                .build();
    }

}
