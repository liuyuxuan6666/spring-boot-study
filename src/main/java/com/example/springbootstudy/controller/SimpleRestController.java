package com.example.springbootstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller中的方法返回的都不带模板
 * RequestMapping表示控制器的基本地址
 */
@RestController
@RequestMapping("rest")
public class SimpleRestController {

    /**
     * 一个普通的REST方法
     * @return
     */
    @GetMapping("hello")
    public String helloWorld() {
        return "Hello World";
    }

}
