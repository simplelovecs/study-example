package com.xyzq.doit.zfq.studyexample.aspectj.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by zhengfq on 2018/4/8.
 */
@Aspect//1
@Component//2
public class LogAspect {
    /*拦截累切点编写*/
    @Pointcut("@annotation(com.xyzq.doit.zfq.studyexample.aspectj.example.Action)")//3
    public  void annotationPointCut(){
        System.out.println("开始拦截--但是不打印");
    }
    /*使用注解方法拦截*/
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature=(MethodSignature)joinPoint.getSignature();
        Method method=signature.getMethod();
        Action action=method.getAnnotation(Action.class);
        System.out.println("注解拦截方式:"+action.name());//5
    }

    /*使用方法规则拦截*/
    @Before("execution(* com.xyzq.doit.zfq.studyexample.aspectj.example.DemoMethodService.*(..))")//6
    public void before(JoinPoint joinPoint){
        MethodSignature signature=(MethodSignature)joinPoint.getSignature();
        Method method=signature.getMethod();
        System.out.println("方法规则拦截方式:"+method.getName());
    }
}
