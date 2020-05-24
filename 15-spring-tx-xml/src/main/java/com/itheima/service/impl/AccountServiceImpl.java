package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import com.itheima.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-24 19:59
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public Account getById(Integer id) {
        return accountDao.getById(id);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        Account sourceAccount = accountDao.getByName(sourceName);
        Account targetAccount = accountDao.getByName(targetName);
        if (sourceAccount != null && targetAccount != null) {
            sourceAccount.setMoney(sourceAccount.getMoney() - money);
            targetAccount.setMoney(targetAccount.getMoney() + money);
            accountDao.update(sourceAccount);
//            int i = 1/0;
            accountDao.update(targetAccount);
        }
    }

}
