package com.itheima.service;

import com.itheima.pojo.Account;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-24 19:58
 */
public interface AccountService {

    Account getById(Integer id);

    void transfer(String sourceName, String targetName, Float money);

}
