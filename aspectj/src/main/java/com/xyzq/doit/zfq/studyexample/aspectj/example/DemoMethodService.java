package com.xyzq.doit.zfq.studyexample.aspectj.example;

import org.springframework.stereotype.Component;

/**
 * Created by zhengfq on 2018/4/8.
 */
@Component
public class DemoMethodService {
    public void add(){
        System.out.println("DemoMethodService执行add方法");
    }
}