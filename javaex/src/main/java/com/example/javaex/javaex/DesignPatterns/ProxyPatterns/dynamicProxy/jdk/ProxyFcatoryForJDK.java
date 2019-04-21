package com.example.javaex.javaex.DesignPatterns.ProxyPatterns.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFcatoryForJDK {

    /**
     * 代理对象的数据类型
     * 应该有监控行为来创建
     * 参数：class文件，监控类
     */
    public static Behavior builder(Class classFile) throws Exception {
        //1.创建被监控实例对象
        Behavior o = (Behavior)classFile.newInstance();
        //2.创建一个通知对象
        InvocationHandler adviser = new Invaction(o);
        /** 参数：被监控对象的类文件在内存中的地址
         *       被监控对象的类隶属文件的实现接口
         *       被监控的行为
         */
        Behavior  $proxy = (Behavior)Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(),adviser);
        return $proxy;

    }
}
