package com.example.javaex.javaex.DesignPatterns.ProxyPatterns.dynamicProxy;


import com.example.javaex.javaex.DesignPatterns.ProxyPatterns.dynamicProxy.cglib.ProxyCglibInvation;
import com.example.javaex.javaex.DesignPatterns.ProxyPatterns.dynamicProxy.cglib.ProxyFcatoryForCglib;
import com.example.javaex.javaex.DesignPatterns.ProxyPatterns.dynamicProxy.cglib.Student;
import com.example.javaex.javaex.DesignPatterns.ProxyPatterns.dynamicProxy.jdk.Behavior;
import com.example.javaex.javaex.DesignPatterns.ProxyPatterns.dynamicProxy.jdk.ChineseBehaviorImpl;
import com.example.javaex.javaex.DesignPatterns.ProxyPatterns.dynamicProxy.jdk.ProxyFcatoryForJDK;

//吃饭前要洗手
public class ProxyMain {


    public static void main(String[] a) throws Exception {

        ProxyMain proxyMain = new ProxyMain();
        proxyMain.jdkProxy();
        proxyMain.cglibProxy();
    }

    /**
     * 只能代理接口实现的类
     *
     * @throws Exception
     */
    public void jdkProxy() throws Exception {
        Behavior b = ProxyFcatoryForJDK.builder(ChineseBehaviorImpl.class);
        b.eat();
    }

    /**
     * 只能子类
     *
     * @throws Exception
     */
    public void cglibProxy() {
//        Student o = (Student) new ProxyCglibInvation(new Student()).bulid();
        Student o  = (Student)new ProxyFcatoryForCglib(new Student(),new ProxyCglibInvation()).bulid();
        o.say();
    }
}
