package com.kaiyu.tuling.a1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component // 必须交给Spring管理，才能生效
public class MyBeanPostProcessor implements BeanPostProcessor {
    // ---------------------- 14. BeanPostProcessor前置处理 ----------------------
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("user".equals(beanName)) { // 只看我们的User Bean
            System.out.println("【14】BeanPostProcessor前置：初始化前，对Bean包装一下");
        }
        return bean;
    }
    // ---------------------- 17. BeanPostProcessor后置处理 ----------------------
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("user".equals(beanName)) {
            System.out.println("【17】BeanPostProcessor后置：初始化后，对Bean再包装一下（AOP在此生成代理对象）");
        }
        return bean;
    }
}
