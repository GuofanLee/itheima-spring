package com.itheima.service.impl;

import com.itheima.service.AccountService;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-17 18:03
 */
public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl() {
        System.out.println("AccountServiceImpl 对象被创建了");
    }

    public AccountServiceImpl(String name) {
        System.out.println("AccountServiceImpl 对象被创建了");
    }

    @Override
    public void saveAccount() {
        System.out.println("AccountServiceImpl 中的 saveAccount() 方法执行了");
    }

    public void init() {
        System.out.println("对象初始化了");
    }

    public void destroy() {
        System.out.println("对象销毁了");
    }

}
