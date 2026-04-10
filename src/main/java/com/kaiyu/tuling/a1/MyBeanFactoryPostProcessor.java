package com.kaiyu.tuling.a1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    // ---------------------- 2、6. Bean工厂后置处理器 ----------------------
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("【2/6】BeanFactoryPostProcessor：Bean工厂创建后，修改BeanDefinition（比如给User的name属性设默认值）");
        // 这里可以偷偷修改User的BeanDefinition！
    }
}
