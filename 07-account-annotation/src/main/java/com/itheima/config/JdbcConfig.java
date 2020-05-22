package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-19 02:48
 */
@Configuration
public class JdbcConfig {

    @Bean
    @Scope("prototype")
    public QueryRunner queryRunner(DataSource dataSource) {
        //如果要使用事务，不要使用这种方式
        return new QueryRunner(dataSource);
    }

    @Bean
    public DataSource dataSource(JdbcInfo jdbcInfo) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcInfo.getDriverClassName());
        dataSource.setUrl(jdbcInfo.getUrl());
        dataSource.setUsername(jdbcInfo.getUsername());
        dataSource.setPassword(jdbcInfo.getPassword());
        dataSource.setInitialSize(jdbcInfo.getInitialSize());
        dataSource.setMinIdle(jdbcInfo.getMinIdle());
        dataSource.setMaxActive(jdbcInfo.getMaxActive());
        return dataSource;
    }

}
