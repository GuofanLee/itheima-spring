package com.itheima.service;

import com.itheima.config.SpringConfiguration;
import com.itheima.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-24 20:17
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Resource
    private AccountService accountService;

    @Test
    public void getById() {
        Account account = accountService.getById(1);
        System.out.println(account);
    }

    @Test
    public void transfer() {
        accountService.transfer("aaa", "bbb", 100f);
    }

}