package com.kaiyu.spring.a10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static java.lang.Thread.sleep;

/**
 * 代理工具类：专门用来生成代理对象
 * 对应截图里的ProxyUtil，封装了代理对象的创建逻辑
 */
public class ProxyUtil {
    /**
     * 代理工具类：专门用来生成代理对象
     * 对应截图里的ProxyUtil，封装了代理对象的创建逻辑
     */
    public static Star createProxy(BigStar bigStar){
        /*
         * 核心方法：Proxy.newProxyInstance，用来在运行时动态生成代理对象
         * 三个参数的含义（和截图里的注释完全对应）：
         * 参数1：ClassLoader loader - 类加载器，用来加载生成的代理类，固定用当前类的类加载器即可
         * 参数2：Class<?>[] interfaces - 代理类要实现的接口，这里就是Star接口，保证代理对象和真实对象有相同的方法
         * 参数3：InvocationHandler h - 处理器，核心！代理对象的所有方法被调用时，都会走到这里的invoke方法
         */
        Star starProxy = (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),// 参数1：类加载器
                new Class[]{Star.class},// 参数2：要实现的接口数组
                new InvocationHandler() { // 参数3：调用处理器，核心增强逻
                    /**
                     * 代理对象的所有方法被调用时，都会执行这个invoke方法
                     * 三个参数的含义（和截图里的注释完全对应）：
                     * @param proxy  生成的代理对象本身（一般不用）
                     * @param method 当前被调用的方法（比如sing、dance方法）
                     * @param args   调用方法时传递的实参（比如sing方法里的歌曲名）
                     * @return 方法的返回值，会返回给调用者
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 1. 方法增强：在调用真实方法前，做额外逻辑（对应截图里的收钱、准备工作）
                        if ("sing".equals(method.getName())) {
                            // 如果调用的是唱歌方法，前置增强
                            System.out.println("【代理增强】准备话筒、音响，收取唱歌出场费！");
                        } else if ("dance".equals(method.getName())) {
                            // 如果调用的是跳舞方法，前置增强
                            System.out.println("【代理增强】准备场地、灯光，收取跳舞出场费！");
                        }// ========== 练习2新增：talk方法的前置增强 ==========
                        else if ("talk".equals(method.getName())) {
                            System.out.println("【代理增强】准备麦克风！");
                        }

                        // 计时开始
                        long start = System.currentTimeMillis();

                        // 执行真实方法
                        Object result = method.invoke(bigStar, args);

                        // 修正后的sleep调用：Thread.sleep(毫秒数)
                        // 这里1000000毫秒 = 1000秒，也就是16分钟多，运行会卡住很久
                        Thread.sleep(5000); // 我改成1000毫秒=1秒，方便你测试

                        // 后置增强 + 计时结束
                        long end = System.currentTimeMillis();
                        System.out.println("【代理增强】表演结束，收尾款，打扫现场！");
                        System.out.println("方法执行耗时：" + (end - start) + "ms");

                        return result;
                    }
                }
        );
        // 返回生成的代理对象
        return starProxy;
    }
}
