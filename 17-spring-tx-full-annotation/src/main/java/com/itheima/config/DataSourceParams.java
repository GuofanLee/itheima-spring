package com.itheima.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-25 02:12
 */
@Component
public class DataSourceParams {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.initialSize}")
    private Integer initialSize;

    @Value("${jdbc.minIdle}")
    private Integer minIdle;

    @Value("${jdbc.maxActive}")
    private Integer maxActive;

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getInitialSize() {
        return initialSize;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

}
