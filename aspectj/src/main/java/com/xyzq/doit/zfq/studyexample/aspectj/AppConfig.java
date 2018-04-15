package com.xyzq.doit.zfq.studyexample.aspectj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by zhengfq on 2018/4/8.
 */
@Configuration
@ComponentScan(basePackages = "com.xyzq.doit.zfq.studyexample.aspectj")
@EnableAspectJAutoProxy//(proxyTargetClass = true)
public class AppConfig {
}
