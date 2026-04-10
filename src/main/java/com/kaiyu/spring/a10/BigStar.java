package com.kaiyu.spring.a10;
/**
 * 大明星：真实的业务对象，被代理的目标对象
 * 实现了Star接口，有具体的唱歌、跳舞逻辑
 */
public class BigStar implements Star{
    // 明星名字
    private String name;

    /**
     * 真实的唱歌逻辑
     */
    @Override
    public String sing(String songName) {
        System.out.println(name + "正在演唱：" + songName);
        return "谢谢大家！演唱完毕！";
    }
    /**
     * 真实的跳舞逻辑
     */
    @Override
    public void dance() {
        System.out.println(name + "跳了一支超帅的舞蹈！");
        System.out.println("<<<<<<<<<<>>>>>>>>>>>>>");
    }

    @Override
    public String talk(String content) {
        System.out.println(name + "发言：" + content);
        return "发言完成，感谢大家的聆听！";
    }

    // getter&setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // 构造方法
    public BigStar(String name) {
        this.name = name;
    }
}
