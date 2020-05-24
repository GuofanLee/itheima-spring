package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

/**
 * 数据库相关配置
 *
 * @author GuofanLee
 * @date 2020-05-25 02:18
 */
@Configuration
public class DataSourceConfig {

    /**
     * 配置数据源
     */
    @Bean
    public DataSource dataSource(DataSourceParams dataSourceParams) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dataSourceParams.getDriverClassName());
        dataSource.setUrl(dataSourceParams.getUrl());
        dataSource.setUsername(dataSourceParams.getUsername());
        dataSource.setPassword(dataSourceParams.getPassword());
        dataSource.setInitialSize(dataSourceParams.getInitialSize());
        dataSource.setMinIdle(dataSourceParams.getMinIdle());
        dataSource.setMaxActive(dataSourceParams.getMaxActive());
        return dataSource;
    }

    /**
     * 配置 JdbcTemplate
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * 配置 Spring 事务管理器
     */
    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
