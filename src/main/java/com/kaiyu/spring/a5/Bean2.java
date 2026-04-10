package com.kaiyu.spring.a5;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
@Slf4j
public class Bean2 implements InitializingBean, DisposableBean {

    @PostConstruct
    public void init1(){
        log.info("初始化1");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
      log.info("初始化2");
    }
    public  void init3(){
        log.info("初始化3");
    }
    // 销毁1：@PreDestroy 注解
    @PreDestroy
    public void destroy1() {
        log.info("销毁1");
    }

    // 销毁2：实现DisposableBean接口
    @Override
    public void destroy() throws Exception {
        log.info("销毁2");
    }

    // 销毁3：自定义销毁方法
    public void destroy3() {
        log.info("销毁3");
    }
}
