package com.itheima.controller;

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
     * 创建对象的方式一：使用默认(无参)构造方法创建的对象
     */
    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = ac.getBean("accountService1", AccountService.class);
        accountService.saveAccount();
    }

    /**
     * 创建对象的方式二：使用普通工厂中的方法创建的对象
     */
    @Test
    public void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = ac.getBean("accountService2", AccountService.class);
        accountService.saveAccount();
    }

    /**
     * 创建对象的方式三：使用工厂中的静态方法创建的对象
     */
    @Test
    public void test3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = ac.getBean("accountService3", AccountService.class);
        accountService.saveAccount();
    }

    /**
     * Bean 的作用范围：singleton(默认：单例)
     */
    @Test
    public void test4() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService1 = ac.getBean("accountService4", AccountService.class);
        AccountService accountService2 = ac.getBean("accountService4", AccountService.class);
        System.out.println(accountService1);
        System.out.println(accountService2);
        System.out.println(accountService1 == accountService2);
    }

    /**
     * Bean 的作用范围：prototype(多例)
     */
    @Test
    public void test5() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService1 = ac.getBean("accountService5", AccountService.class);
        AccountService accountService2 = ac.getBean("accountService5", AccountService.class);
        System.out.println(accountService1);
        System.out.println(accountService2);
        System.out.println(accountService1 == accountService2);
    }

    /**
     * 单例对象的生命周期
     */
    @Test
    public void test6() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = ac.getBean("accountService6", AccountService.class);
        accountService.saveAccount();
        ac.close();
    }

    /**
     * 多例对象的生命周期
     */
    @Test
    public void test7() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService1 = ac.getBean("accountService7", AccountService.class);
        AccountService accountService2 = ac.getBean("accountService7", AccountService.class);
        System.out.println(accountService1);
        System.out.println(accountService2);
        System.out.println(accountService1 == accountService2);
        ac.close();
    }

}
