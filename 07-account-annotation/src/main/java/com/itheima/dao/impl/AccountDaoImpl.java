package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-18 19:47
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Resource
    private QueryRunner queryRunner;

    @Override
    public List<Account> getAll() {
        try {
            String sql = "select * from account";
            return queryRunner.query(sql, new BeanListHandler<>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account getById(Integer id) {
        try {
            String sql = "select * from account where id = ?";
            return queryRunner.query(sql, new BeanHandler<>(Account.class), id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Account account) {
        try {
            String sql = "insert into account (name, money) values (?, ?)";
            queryRunner.update(sql, account.getName(), account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Account account) {
        try {
            String sql = "update account set name = ?, money = ? where id = ?";
            queryRunner.update(sql, account.getName(), account.getMoney(), account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String sql = "delete from account where id = ?";
            queryRunner.update(sql, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
