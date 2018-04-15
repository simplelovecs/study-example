package com.xyzq.doit.zfq.studyexample.aspectj;


import org.springframework.stereotype.Component;

@Component
public class AopDemoService {
    public void testMethod(String id) {
        System.out.println("参数："+id);
    }

    public void testMethod2(String idd) {
        System.out.println("参数idd："+idd);
    }
}
