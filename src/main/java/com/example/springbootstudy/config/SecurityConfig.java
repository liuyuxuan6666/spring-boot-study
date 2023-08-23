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
        // 放行所有接口对所有路由
        httpSecurity.authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .csrf()
                .disable();

        // 禁用frameOptions安全策略，此项配置用于解决H2的console打不开的问题
        httpSecurity.headers().frameOptions().disable();

        // 返回，需要build一下才会返回合适的类型
        return httpSecurity.build();
    }

}
