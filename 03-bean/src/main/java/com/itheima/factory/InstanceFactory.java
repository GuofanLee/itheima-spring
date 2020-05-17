package com.itheima.factory;

import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类，用来获取 AccountServiceImpl 对象
 *
 * @author GuofanLee
 * @date 2020-05-17 23:00
 */
public class InstanceFactory {

    public AccountService getAccountService() {
        return new AccountServiceImpl();
    }

}
