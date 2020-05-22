package com.itheima.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-18 21:28
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class AccountServiceTest {

    @Resource(name = "accountServiceProxy")
    private AccountService accountService;

    @Test
    public void testTransfer() {
        accountService.transfer("aaa", "bbb", 100f);
    }

}