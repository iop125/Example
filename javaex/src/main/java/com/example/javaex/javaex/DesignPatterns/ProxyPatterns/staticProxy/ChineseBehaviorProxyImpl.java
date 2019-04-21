package com.example.javaex.javaex.DesignPatterns.ProxyPatterns.staticProxy;

public class ChineseBehaviorProxyImpl implements Behavior {

    private Behavior behavior;//具体被监控的对象

    public ChineseBehaviorProxyImpl(Behavior behavior) {
        this.behavior = behavior;
    }

    @Override
    public void eat() {
        wash();
        behavior.eat();
    }

    public void wash() {
        System.out.println("洗手");
    }

    public static void main(String [] a){
        ChineseBehaviorImpl chineseBehaviorImpl =new ChineseBehaviorImpl();
        ChineseBehaviorProxyImpl ChineseBehaviorProxyImpl = new ChineseBehaviorProxyImpl(chineseBehaviorImpl);
        ChineseBehaviorProxyImpl.eat();
    }
}
