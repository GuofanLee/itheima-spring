package com.itheima.service.impl;

import com.itheima.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-23 05:31
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public void add() {
        System.out.println("执行了保存操作");
    }

    @Override
    public void update(int id) {
        System.out.println("执行了更新操作 id：" + id);
    }

    @Override
    public int delete() {
        System.out.println("执行了删除操作");
        return 0;
    }

}
