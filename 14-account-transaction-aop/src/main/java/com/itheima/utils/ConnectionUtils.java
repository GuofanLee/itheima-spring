package com.itheima.utils;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 获取数据库连接的工具类
 *
 * @author GuofanLee
 * @date 2020-05-23 01:22
 */
@Component
public class ConnectionUtils {

    @Resource
    private DataSource dataSource;

    private final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    /**
     * 获取数据库连接
     */
    public Connection getConnection() {
        Connection connection = connectionThreadLocal.get();
        if (connection == null) {
            try {
                connection = dataSource.getConnection();
                connectionThreadLocal.set(connection);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    /**
     * 释放当前 ThreadLocal 中的数据库连接池
     */
    public void removeConnection() {
        connectionThreadLocal.remove();
    }

}
