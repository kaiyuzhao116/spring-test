package com.kaiyu.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// 关键：启动类，会扫描当前包及其子包下的所有组件
@Slf4j
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 启动容器
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        // 👇 关键：主动获取多例Bean A，触发真正的创建流程
//        Test.A a = context.getBean(Test.A.class);
//        System.out.println("获取到A了：" + a);
    }
}