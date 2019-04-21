package com.example.javaex.javaex.DesignPatterns.ProxyPatterns.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 通知类
 */
public class Invaction implements InvocationHandler {

    private Behavior behavior;//具体被监控的对象

    public Invaction(Behavior behavior) {
        this.behavior = behavior;
    }

    /**
     * 在被监控的行为简要执行是会被jvm拦截
     * 被监控的行为和行为实现方会被作为参数给invoke
     * 通知jvm 这个拦截防范是如何与次要业务相结合的
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object o = null;
        if (method.getName().equals("eat")) {
            wash();
            o = method.invoke(behavior, args);
        }
        return o;
    }
    public void wash() {
        System.out.println("洗手");
    }
}
