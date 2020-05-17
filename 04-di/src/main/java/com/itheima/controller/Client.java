package com.itheima.controller;

import com.itheima.pojo.CollectionBean;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个 Controller
 *
 * @author GuofanLee
 * @date 2020-05-17 18:08
 */
public class Client {

    /**
     * 构造方法注入
     */
    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = ac.getBean("accountService1", AccountService.class);
        System.out.println(accountService);
    }

    /**
     * set 方法注入
     */
    @Test
    public void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = ac.getBean("accountService2", AccountService.class);
        System.out.println(accountService);
    }

    /**
     * 复杂类型注入
     */
    @Test
    public void test3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        CollectionBean collectionBean = ac.getBean("collectionBean", CollectionBean.class);
        System.out.println(collectionBean);
    }


}
