package com.itheima.config;

import com.itheima.proxy.ServiceTransactionProxyFactory;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-23 04:09
 */
@Configuration
public class ServiceProxyConfig {

    /**
     * Service 类的代理工厂类
     */
    @Resource
    private ServiceTransactionProxyFactory proxyFactory;

    /**
     * 返回 AccountService 的代理类对象
     */
    @Bean("accountServiceProxy")
    public AccountService accountService(@Qualifier("accountServiceImpl") AccountService accountService) {
        return (AccountService) proxyFactory.getProxyInstance(accountService);
    }

}
