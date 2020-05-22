package com.itheima.dao;

import com.itheima.pojo.Account;

import java.util.List;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-18 19:42
 */
public interface AccountDao {

    List<Account> getAll();

    Account getById(Integer id);

    void add(Account account);

    void update(Account account);

    void delete(Integer id);

    Account getByName(String accountName);

}
