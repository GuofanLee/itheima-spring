package com.itheima.dao;

import com.itheima.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-23 21:29
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class AccountDaoTest {

    @Resource
    private AccountDao accountDao;

    @Test
    public void addTest() {
        int affectedRow = accountDao.add(new Account(null, "eee", 1000f));
        System.out.println(affectedRow);
    }

    @Test
    public void updateByIdTest() {
        int affectedRow = accountDao.updateById(new Account(11, "fff", 2000f));
        System.out.println(affectedRow);
    }

    @Test
    public void deleteByIdTest() {
        int affectedRow = accountDao.deleteById(11);
        System.out.println(affectedRow);
    }

    @Test
    public void getAllTest() {
        List<Account> accounts = accountDao.getAll();
        accounts.forEach(System.out::println);
    }

    @Test
    public void getListTest() {
        List<Account> accounts = accountDao.getList();
        accounts.forEach(System.out::println);
    }

    @Test
    public void getNameByIdTest() {
        String name = accountDao.getNameById(1);
        System.out.println(name);
    }

    @Test
    public void getCountTest() {
        Integer count = accountDao.getCount();
        System.out.println(count);
    }

}