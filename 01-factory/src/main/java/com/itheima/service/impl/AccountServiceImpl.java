package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.factory.BeanFactory;
import com.itheima.service.AccountService;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-17 18:03
 */
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }

}
