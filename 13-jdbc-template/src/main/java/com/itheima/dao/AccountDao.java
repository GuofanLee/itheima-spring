package com.itheima.dao;

import com.itheima.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-23 20:09
 */
@Repository
public class AccountDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    //使用 JdbcTemplate 进行插入操作
    public int add(Account account) {
        String sql = "insert into account (name, money) values (? , ?)";
        return jdbcTemplate.update(sql, account.getName(), account.getMoney());
    }

    //使用 JdbcTemplate 进行更行操作
    public int updateById(Account account) {
        String sql = "update account set name = ?, money = ? where id = ?";
        return jdbcTemplate.update(sql, account.getName(), account.getMoney(), account.getId());
    }

    //使用 JdbcTemplate 进行删除操作
    public int deleteById(Integer id) {
        String sql = "delete from account where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    /**
     * 下面两个方法都是演示用 List 封装 Java Bean 类型的结果集
     * 两个方法的区别在于一个是手动映射结果集，一个是使用 Spring 提供的自动映射结果集
     */

    //使用 JdbcTemplate 查询所有记录
    public List<Account> getAll() {
        String sql = "select * from account";
        return jdbcTemplate.query(sql, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setName(rs.getString("name"));
                account.setMoney(rs.getFloat("money"));
                return account;
            }
        });
    }

    //使用 JdbcTemplate 查询满足条件的记录，并将结果封装到 List 中
    public List<Account> getList() {
        String sql = "select * from account where money > ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class), 100f);
    }

    /**
     * 下面两个方法都是演示查询单值数据
     */

    //使用 JdbcTemplate 查询指定 id 的账户名称
    public String getNameById(Integer id) {
        String sql = "select name from account where id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, id);
    }

    //使用 JdbcTemplate 查询总记录数
    public Integer getCount() {
        String sql = "select count(*) from account";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

}
