package com.example.springbootstudy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller中的方法返回的都不带模板
 */
@RestController
@RequestMapping("/")
public class TeacherController {

    /**
     * Value可以从配置文件中获取值
     */
    @Value("${spring.application.name}")
    String appName;

    /**
     * 一个普通的REST方法
     * @return
     */
    @GetMapping("hello")
    public String helloWorld() {
        return "HelloWolrd";
    }

    /**
     * 含模板的方法
     * 模板使用String类型返回的
     * @return
     */
    @GetMapping("page")
    public String helloPage(Model model) {
        model.addAttribute("appName", this.appName);
        return "home";
    }
}
