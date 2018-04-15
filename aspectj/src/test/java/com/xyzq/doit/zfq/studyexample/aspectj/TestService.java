package com.xyzq.doit.zfq.studyexample.aspectj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by zhengfq on 2018/4/8.
 */
public class TestService {
    @Test
    public void aaa() {
//        AopDemoService s = new AopDemoService();
//        s.testMethod("zhengfq");
//        s.testMethod2("zhengfq");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        AopDemoService myService = ctx.getBean(AopDemoService.class);
        myService.testMethod("zhengfq");
        myService.testMethod2("zhengfq");
    }
}
