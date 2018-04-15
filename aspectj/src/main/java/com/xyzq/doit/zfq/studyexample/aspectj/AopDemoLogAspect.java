package com.xyzq.doit.zfq.studyexample.aspectj;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopDemoLogAspect {

    // 配置切点 及要传的参数
    @Pointcut("execution(* com.xyzq.doit.zfq.studyexample.aspectj.AopDemoService.*(..)) && args(id)")
    public void pointCut(String id) {

    }

//    // 配置切点 及要传的参数
//    @Pointcut("execution(* com.xyzq.doit.zfq.studyexample.aspectj.AopDemoService.*(..))")
//    public void pointCut2() {
//
//    }
//    // 配置连接点 方法开始执行时通知
//    @Before("pointCut2()")
//    public void beforeLog() {
//        System.out.println("开始执行前置通知  日志记录:pointCut2");
//    }


    // 配置连接点 方法开始执行时通知
    @Before("pointCut(id)")
    public void beforeLog(String id) {
        System.out.println("开始执行前置通知  日志记录:" + id);
    }

    //    方法执行完后通知
    @After("pointCut(id)")
    public void afterLog(String id) {
        System.out.println("开始执行后置通知 日志记录:" + id);
    }

    //    执行成功后通知
    @AfterReturning("pointCut(id)")
    public void afterReturningLog(String id) {
        System.out.println("方法成功执行后通知 日志记录:" + id);
    }

    //    抛出异常后通知
    @AfterThrowing("pointCut(id)")
    public void afterThrowingLog(String id) {
        System.out.println("方法抛出异常后执行通知 日志记录" + id);
    }

    //    环绕通知
    @Around("pointCut(id)")
    public Object aroundLog(ProceedingJoinPoint joinpoint, String id) {
        Object result = null;
        try {
            System.out.println("环绕通知开始 日志记录" + id);
            long start = System.currentTimeMillis();

            //有返回参数 则需返回值
            result = joinpoint.proceed();

            long end = System.currentTimeMillis();
            System.out.println("总共执行时长" + (end - start) + " 毫秒");
            System.out.println("环绕通知结束 日志记录");
        } catch (Throwable t) {
            System.out.println("出现错误");
        }
        return result;
    }
}
