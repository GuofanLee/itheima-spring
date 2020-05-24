package com.itheima.dao;

import com.itheima.pojo.Account;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-24 20:06
 */
public interface AccountDao {

    Account getById(Integer id);

    Account getByName(String sourceName);

    void update(Account sourceAccount);

}
