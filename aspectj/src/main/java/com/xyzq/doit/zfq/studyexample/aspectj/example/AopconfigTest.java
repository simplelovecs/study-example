package com.xyzq.doit.zfq.studyexample.aspectj.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by zhengfq on 2018/4/8.
 */
@Configuration
@ComponentScan("com.xyzq.doit.zfq.studyexample.aspectj.example")
@EnableAspectJAutoProxy//1
public class AopconfigTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopconfigTest.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);

        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);

        demoAnnotationService.add();

        demoMethodService.add();
    }
}
