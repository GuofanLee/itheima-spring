package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-18 23:19
 */
@Configuration
@Import(JdbcConfig.class)
@ComponentScan("com.itheima")
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {

}
