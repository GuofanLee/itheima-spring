package com.itheima.utils;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-23 01:36
 */
@Component
public class TransactionManager {

    @Resource
    private ConnectionUtils connectionUtils;

    /**
     * 开启事务
     */
    public void beginTransaction() {
        try {
            connectionUtils.getConnection().setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 提交事务
     */
    public void commit() {
        try {
            connectionUtils.getConnection().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        try {
            connectionUtils.getConnection().rollback();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 释放连接
     */
    public void release() {
        try {
            connectionUtils.getConnection().setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connectionUtils.getConnection().close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connectionUtils.removeConnection();
            }
        }
    }

}
