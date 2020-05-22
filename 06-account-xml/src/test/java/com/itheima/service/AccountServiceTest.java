package com.itheima.service;

import com.itheima.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-18 21:28
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void getAll() {
        List<Account> accounts = accountService.getAll();
        accounts.forEach(System.out::println);
    }

    @Test
    public void getById() {
        Account account = accountService.getById(1);
        System.out.println(account);
    }

    @Test
    public void add() {
        accountService.add(new Account(null, "test", 1000f));
        List<Account> accounts = accountService.getAll();
        accounts.forEach(System.out::println);
    }

    @Test
    public void update() {
        accountService.update(new Account(4, "ddd", 2000f));
        List<Account> accounts = accountService.getAll();
        accounts.forEach(System.out::println);
    }

    @Test
    public void delete() {
        accountService.delete(5);
        List<Account> accounts = accountService.getAll();
        accounts.forEach(System.out::println);
    }

}