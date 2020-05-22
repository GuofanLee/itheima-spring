package com.itheima.utils;

import org.springframework.stereotype.Component;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-23 05:32
 */
@Component
public class Logger {

    /**
     * 用于模拟打印日志，在切入点执行之前执行
     */
    public void printLog() {
        System.out.println("Logger 类中的 printLog 方法开始记录日志");
    }

}
