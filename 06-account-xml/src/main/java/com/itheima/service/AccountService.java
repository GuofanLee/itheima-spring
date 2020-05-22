package com.itheima.service;

import com.itheima.pojo.Account;

import java.util.List;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-18 19:37
 */
public interface AccountService {

    List<Account> getAll();

    Account getById(Integer id);

    void add(Account account);

    void update(Account account);

    void delete(Integer id);

}
