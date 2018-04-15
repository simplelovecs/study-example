package com.xyzq.doit.zfq.studyexample.aspectj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by zhengfq on 2018/4/8.
 */
public class AopConfigTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AopDemoService myService = context.getBean(AopDemoService.class);
        myService.testMethod("zhengfq");
        myService.testMethod2("zhengfq");

//        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
//
//        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
//
//        demoAnnotationService.add();
//
//        demoMethodService.add();
    }
}
