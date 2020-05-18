package com.itheima.controller;

import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个 Controller
 *
 * @author GuofanLee
 * @date 2020-05-17 18:08
 */
public class Client {

    @Test
    public void test2() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService1 = ac.getBean(AccountService.class);
        accountService1.saveAccount();
        AccountService accountService2 = ac.getBean(AccountService.class);
        System.out.println(accountService1 == accountService2);
        ac.close();
    }

}
