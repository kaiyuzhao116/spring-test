package com.kaiyu.tuling.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan // 扫描上面3个类
public class IocFullTest {
    public static void main(String[] args) {
        // ---------------------- 1. 实例化ApplicationContext ----------------------
        System.out.println("【1】========== 启动Spring容器，实例化ApplicationContext ==========");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocFullTest.class);

        // ---------------------- 18. 获取成品Bean，使用 ----------------------
        System.out.println("\n【获取成品】========== 从单例池获取完整的User Bean ==========");
        User user = context.getBean(User.class);
        System.out.println("【使用Bean】成品Bean可以正常使用了：" + user);

        // ---------------------- 19. 关闭容器，触发销毁 ----------------------
        System.out.println("\n【关闭容器】========== 关闭Spring容器，触发Bean销毁 ==========");
        context.close();
    }
}