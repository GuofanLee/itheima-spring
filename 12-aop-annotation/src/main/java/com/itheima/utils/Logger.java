package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-23 05:32
 */
@Aspect
@Component
public class Logger {

    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    private void pointcut(){}

    /**
     * 模拟前置通知
     */
    @Before("pointcut()")
    public void before() {
        System.out.println("前置通知");
    }

    /**
     * 模拟后置通知
     */
    @After("pointcut()")
    public void after() {
        System.out.println("后置通知");
    }

    /**
     * 模拟异常通知
     */
    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("异常通知");
    }

    /**
     * 模拟返回通知
     */
    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("返回通知");
    }

    /**
     * 模拟环绕通知
     */
    //@Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("调用方法前执行，相当于前置通知");
            //调用被代理（切入点）方法
            Object returnValue = joinPoint.proceed(joinPoint.getArgs());
            System.out.println("方法正常返回前执行，相当于返回通知");
            return returnValue;
        } catch (Throwable e) {
            System.out.println("发生异常后执行，相当于异常通知");
            throw new RuntimeException(e);
        } finally {
            System.out.println("调用方法后执行，相当于后置通知");
        }
    }

}
