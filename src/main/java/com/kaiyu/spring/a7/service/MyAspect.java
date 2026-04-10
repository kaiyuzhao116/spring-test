package com.kaiyu.spring.a7.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Slf4j
@Aspect
//@Component
public class MyAspect {
    @Before("execution(* com.kaiyu.spring.a7.service.MyService.foo())")
    public void before(){
        log.info("before()");
    }
}
