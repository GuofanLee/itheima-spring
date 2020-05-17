package com.itheima.controller;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个 Controller
 *
 * @author GuofanLee
 * @date 2020-05-17 18:08
 */
public class Client {

    /**
     * 使用 ClassPathXmlApplicationContext 加载类路径下的 Spring 配置文件
     *
     * ApplicationContext 构建 IOC 容器采用的是立即加载的策略：
     * 即加载完 Spring  配置文件就立即创建配置文件中配置的 Bean 对象。
     */
    @Test
    public void test1() {
        //1、根据 xml 配置文件创建 IOC 容器
        //ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\bean.xml");
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、根据 xml 配置文件中配置的 bean 的 id 从容器中获取对象，需要强制类型转换
        AccountService accountService = (AccountService) ac.getBean("accountService");
        //3、根据要获取的对象的 class 对象获取对象，不需要强制类型转换
        AccountDao accountDao1 = ac.getBean(AccountDao.class);
        //4、同时指定 bean 的 id 和 对象的 class 对象获取对象，不需要强制类型转换
        AccountDao accountDao2 = ac.getBean("accountDao", AccountDao.class);
        System.out.println(accountService);
        System.out.println(accountDao1);
        System.out.println(accountDao2);
        //1、Spring IOC 容器中创建的对象默认是单例的
        System.out.println(accountDao1 == accountDao2);
    }

    /**
     * 使用 FileSystemXmlApplicationContext 加载磁盘中任意路径下的 Spring 配置文件
     *
     * ApplicationContext 构建 IOC 容器采用的是立即加载的策略：
     * 即加载完 Spring  配置文件就立即创建配置文件中配置的 Bean 对象。
     */
    @Test
    public void test2() {
        ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        AccountDao accountDao1 = ac.getBean(AccountDao.class);
        AccountDao accountDao2 = ac.getBean("accountDao", AccountDao.class);
        System.out.println(accountService);
        System.out.println(accountDao1);
        System.out.println(accountDao2);
        //Spring IOC 容器中创建的对象默认是单例的
        System.out.println(accountDao1 == accountDao2);
    }

    /**
     * 使用 BeanFactory 加载类路径下的 Spring 配置文件，并创建 IOC 容器
     *
     * BeanFactory 构建 IOC 容器采用的是延迟加载的策略：
     * 即加载 Spring 配置文件的时候不创建对象，第一次从 IOC 容器中获取对象的时候才创建对象。
     */
    @Test
    public void test3() {
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        AccountService accountService = (AccountService) factory.getBean("accountService");
        AccountDao accountDao1 = factory.getBean(AccountDao.class);
        AccountDao accountDao2 = factory.getBean("accountDao", AccountDao.class);
        System.out.println(accountService);
        System.out.println(accountDao1);
        System.out.println(accountDao2);
        //1、Spring IOC 容器中创建的对象默认是单例的
        System.out.println(accountDao1 == accountDao2);
    }

}
