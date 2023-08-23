package com.example.springbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @SpringBootApplication 基本注解：表示这是一个SpringBoot程序，
 * 相当于 @Configuration, @EnableAutoConfiguration以及 @ComponentScan 三个注解
 */
@SpringBootApplication
/**
 * @EnableJpaRepositories 扫描某个包中的数据仓库接口
 * 这两个注解即使不写，也会自动配置
 */
@EnableJpaRepositories("com.example.springbootstudy.repository")
/**
 * @EntityScan 注解用以扫描某个包中的JPA实体类
 * 这两个注解即使不写，也会自动配置
 */
@EntityScan("com.example.springbootstudy.entity")
public class SpringBootStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudyApplication.class, args);
    }

}
