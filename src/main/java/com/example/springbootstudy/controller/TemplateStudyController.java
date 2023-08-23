package com.example.springbootstudy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Controller表示是一个基于模板的控制器
 * @RequestMapping表示控制器的基本地址
 */
@Controller
@RequestMapping("page")
public class TemplateStudyController {

    /**
     * @Value 可以从配置文件中获取值
     */
    @Value("${spring.application.name}")
    String appName;

    /**
     * 含模板的方法
     * 模板使用String类型返回
     * @return
     */
    @GetMapping("hello")
    public String helloPage(Model model) {
        // 模板插值，这个值传过去之后，在V层就可以使用${appName}来调用
        model.addAttribute("appName", this.appName);
        // 此处表面上返回了一个字符串，实际上这个字符串是文件名，必须和模板名称对应
        return "home";
    }

}
