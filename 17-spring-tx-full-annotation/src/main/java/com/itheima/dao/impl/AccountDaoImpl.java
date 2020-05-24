package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-23 20:09
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account getById(Integer id) {
        String sql = "select * from account where id = ?";
        List<Account> accounts = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class), id);
        if (accounts.isEmpty()) {
            return null;
        }
        return accounts.get(0);
    }

    @Override
    public Account getByName(String accountName) {
        String sql = "select * from account where name = ?";
        List<Account> accounts = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class), accountName);
        if (accounts.isEmpty()) {
            return null;
        }
        return accounts.get(0);
    }

    @Override
    public void update(Account account) {
        String sql ="update account set name = ?, money = ? where id = ?";
        jdbcTemplate.update(sql, account.getName(), account.getMoney(), account.getId());
    }

}
