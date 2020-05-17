package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-17 18:03
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }

}
