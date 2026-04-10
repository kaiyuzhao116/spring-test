package com.kaiyu.spring.a8;

public class Student {
    public String name;
    public int age;

    public Student(){
    }
    public Student(String name){
        this.name = name;
    }
    public Student(int age){
        this.age = age;
    }
    private Student(String name,int age){
        this.age= age;
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    // 核心：重写toString()方法，打印对象时输出属性信息
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
