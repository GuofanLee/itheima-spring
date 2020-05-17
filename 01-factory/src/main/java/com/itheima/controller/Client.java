package com.itheima.controller;

import com.itheima.factory.BeanFactory;
import com.itheima.service.AccountService;

/**
 * 模拟一个 Controller
 *
 * @author GuofanLee
 * @date 2020-05-17 18:08
 */
public class Client {

    private static final AccountService accountService = (AccountService) BeanFactory.getBean("accountService");

    public static void main(String[] args) {
        accountService.saveAccount();
    }

}
