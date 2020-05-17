package com.itheima.factory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 用来创建、管理、获取 Bean 对象的工厂类
 *
 * Bean 在计算机中代表“可重用组件”
 *
 * @author GuofanLee
 * @date 2020-05-17 18:14
 */
public class BeanFactory {

    //用于存放创建的对象的容器
    private static final Map<String, Object> beanContainer;

    //用户加载配置文件
    private static final Properties properties;

    /*
     * 读取配置文件，初始化容器
     */
    static {
        try {
            beanContainer = new HashMap<>();
            properties = new Properties();
            InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(resourceAsStream);
            //创建配置文件中配置的所有 bean 的对象，并将其保存到 map 容器中
            Set<Object> keySet = properties.keySet();
            for (Object keyObj : keySet) {
                String key = keyObj.toString();
                String beanPath = properties.getProperty(key);
                Object bean = Class.forName(beanPath).newInstance();
                beanContainer.put(key, bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("BeanFactory 初始化失败！");
        }
    }

    /**
     * 根据 Bean 名称或取 Bean 对象
     */
    public static Object getBean(String beanName) {
        return beanContainer.get(beanName);
    }

}
