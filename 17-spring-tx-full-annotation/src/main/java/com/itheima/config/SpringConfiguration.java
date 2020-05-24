package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring 主配置类
 *
 * @author GuofanLee
 * @date 2020-05-25 02:10
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.itheima")
@Import(DataSourceConfig.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {

}
