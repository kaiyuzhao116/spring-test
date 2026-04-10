package com.kaiyu.spring.a4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Slf4j
public class MyBean implements BeanNameAware, ApplicationContextAware, InitializingBean {

    @Override
    public void setBeanName(String name) {
        log.debug("当前bean" +this+ "名字叫" + name);
        System.out.println("当前bean" +this+ "名字叫" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("当前bean" +this+ "名字叫" + applicationContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
