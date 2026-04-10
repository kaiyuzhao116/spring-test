package com.kaiyu.tuling.a1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component // 让Spring扫描到
public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    private String name; // 普通属性，用于演示注入
    // ---------------------- 9. 构造方法（反射实例化） ----------------------
    public User() {
        System.out.println("【9】反射调用无参构造：创建空对象（半成品，name=null）");
    }
    // ---------------------- 12. 属性注入（DI） ----------------------
    public void setName(String name) {
        this.name = name;
        System.out.println("【12】属性注入：setName() 执行，name = " + name);
    }
    // ---------------------- 13. Aware接口回调（3个+1个） ----------------------
    @Override
    public void setBeanName(String beanName) {
        System.out.println("【13-1】BeanNameAware回调：当前Bean名字 = " + beanName);
    }
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("【13-2】BeanClassLoaderAware回调：类加载器 = " + classLoader);
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【13-3】BeanFactoryAware回调：Bean工厂 = " + beanFactory);
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【13-4】ApplicationContextAware回调：Spring容器 = " + applicationContext);
    }
    // ---------------------- 15. 初始化方法1：@PostConstruct ----------------------
    @PostConstruct
    public void postConstruct() {
        System.out.println("【15】@PostConstruct初始化：Bean属性填充完毕，执行自定义初始化");
    }

    // ---------------------- 16. 初始化方法2：InitializingBean接口 ----------------------
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【16】InitializingBean.afterPropertiesSet()：属性设置后执行");
    }

    // ---------------------- 18. 销毁方法1：@PreDestroy ----------------------
    @PreDestroy
    public void preDestroy() {
        System.out.println("【18-1】@PreDestroy销毁：容器关闭前，执行自定义销毁");
    }

    // ---------------------- 19. 销毁方法2：DisposableBean接口 ----------------------
    @Override
    public void destroy() throws Exception {
        System.out.println("【18-2】DisposableBean.destroy()：Bean销毁前执行");
    }
}
