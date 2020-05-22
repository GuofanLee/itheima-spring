package com.itheima.proxy;

import com.itheima.utils.TransactionManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Service 类的事务功能代理工厂类
 *
 * @author GuofanLee
 * @date 2020-05-23 03:52
 */
@Component
public class ServiceTransactionProxyFactory {

    @Resource
    private TransactionManager transactionManager;

    /**
     * 为 Service 类添加事务
     */
    public Object getProxyInstance(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue = null;
                try {
                    //开启事务
                    transactionManager.beginTransaction();
                    //执行操作
                    returnValue = method.invoke(obj, args);
                    //提交事务
                    transactionManager.commit();
                    return returnValue;
                } catch (Exception e) {
                    //回滚事务
                    transactionManager.rollback();
                    throw new RuntimeException(e);
                } finally {
                    //释放连接
                    transactionManager.release();
                }
            }
        });
    }

}
