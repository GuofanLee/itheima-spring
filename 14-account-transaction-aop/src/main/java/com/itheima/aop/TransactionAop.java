package com.itheima.aop;

import com.itheima.utils.TransactionManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-23 23:15
 */
@Aspect
@Component
public class TransactionAop {

    @Resource
    private TransactionManager transactionManager;

    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    public void pointcut() {}

    @Around("pointcut()")
    public Object transaction(ProceedingJoinPoint joinPoint) {
        try {
            transactionManager.beginTransaction();
            Object returnValue = joinPoint.proceed(joinPoint.getArgs());
            transactionManager.commit();
            return returnValue;
        } catch (Throwable t) {
            transactionManager.rollback();
            throw new RuntimeException(t);
        } finally {
            transactionManager.release();
        }
    }

}
