package com.xyzq.doit.zfq.studyexample.aspectj.example;

import org.springframework.stereotype.Service;

/**
 * Created by zhengfq on 2018/4/8.
 */
@Service
public class DemoAnnotationService {
    @Action(name = "注解连接add方法操作")
    public void add(){
        System.out.println("DemoAnnotationService执行add方法");
    }
}