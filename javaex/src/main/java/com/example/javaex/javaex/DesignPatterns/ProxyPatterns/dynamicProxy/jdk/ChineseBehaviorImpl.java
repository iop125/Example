package com.example.javaex.javaex.DesignPatterns.ProxyPatterns.dynamicProxy.jdk;

public class ChineseBehaviorImpl implements Behavior {

    @Override
    public void eat() {
        System.out.println("中国人开始吃饭了");
    }
}
