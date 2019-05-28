package com.xyzq.doit.zfq.studyexample.springboot.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloWorld {

    @RequestMapping("/")
    public String home() {
        return "Hello World!zhengfq不行啊 ";
    }

    @RequestMapping("/pecorp/allusers")
    public Map allusers() {
        Map ret = new HashMap<>();
        Map respbody = new HashMap<>();
        List list = new ArrayList<>();
        respbody.put("data", list);
        for (int i = 0; i < 3; i++) {
            Map data = new HashMap();
            data.put("loginId", "loginId");
            data.put("userName", "员工姓名"+i);
            list.add(data);
        }
        ret.put("respbody", respbody);
        return ret;
//        return "Hello World!zhengfq不行啊 ";
    }


    @RequestMapping("/pecorp/tree")
    public Map tree() {
        return null;
    }
}
