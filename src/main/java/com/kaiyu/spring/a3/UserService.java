package com.kaiyu.spring.a3;

//@Component
public class UserService {
    @MyCount
    public void addUser(){
        System.out.println("添加用户！！");
    }
}
