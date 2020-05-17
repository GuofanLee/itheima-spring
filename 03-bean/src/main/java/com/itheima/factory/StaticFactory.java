package com.itheima.factory;

import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-17 23:30
 */
public class StaticFactory {

    public static AccountService getAccountService() {
        return new AccountServiceImpl();
    }

}
