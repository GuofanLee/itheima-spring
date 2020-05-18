package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-17 18:05
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Override
    public void saveAccount() {
        System.out.println("保存了一个账户");
    }

}
