package com.kaiyu.spring.a10;
/**
 * 明星接口：定义明星的核心能力
 * 代理对象和真实对象都会实现这个接口，保证方法统一
 */
public interface Star {
    /**
     * 唱歌方法
     * @param songName 要唱的歌曲名
     * @return 演唱结果
     */
    String sing(String songName);

    void dance();
    /**
     * 【练习2新增】发言方法
     * @param content 要发言的内容
     * @return 发言结果
     */
    String talk(String content);
}
