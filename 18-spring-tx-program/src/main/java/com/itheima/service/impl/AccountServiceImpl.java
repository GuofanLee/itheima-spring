package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import com.itheima.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

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

    @Resource
    private TransactionTemplate transactionTemplate;

    @Override
    public Account getById(Integer id) {
        return accountDao.getById(id);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                //业务代码
                Account sourceAccount = accountDao.getByName(sourceName);
                Account targetAccount = accountDao.getByName(targetName);
                if (sourceAccount != null && targetAccount != null) {
                    sourceAccount.setMoney(sourceAccount.getMoney() - money);
                    targetAccount.setMoney(targetAccount.getMoney() + money);
                    accountDao.update(sourceAccount);
                    //模拟异常
//                    int i = 1/0;
                    accountDao.update(targetAccount);
                }
                return null;
                //业务代码结束
            }
        });
    }

}
