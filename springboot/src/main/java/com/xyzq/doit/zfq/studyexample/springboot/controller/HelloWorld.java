package com.xyzq.doit.zfq.studyexample.springboot.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/")
    String home() {
        return "Hello World!zhengfq不行啊 ";
    }

}
