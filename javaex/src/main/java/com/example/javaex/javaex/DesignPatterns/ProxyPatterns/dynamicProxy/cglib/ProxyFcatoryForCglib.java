package com.example.javaex.javaex.DesignPatterns.ProxyPatterns.dynamicProxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class ProxyFcatoryForCglib {


    private Object target;//业务类对象，供代理方法中进行真正的业务方法调用
    private ProxyCglibInvation proxyCglibInvation;

    public ProxyFcatoryForCglib(Object target, ProxyCglibInvation proxyCglibInvation) {
        this.target = target;
        this.proxyCglibInvation = proxyCglibInvation;
    }

    //相当于JDK动态代理中的绑定
    public Object bulid() {
        Enhancer enhancer = new Enhancer(); //创建加强器，用来创建动态代理类
        enhancer.setSuperclass(this.target.getClass());  //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
        enhancer.setCallback(proxyCglibInvation);
        // 创建动态代理类对象并返回
        return enhancer.create();
    }
}
