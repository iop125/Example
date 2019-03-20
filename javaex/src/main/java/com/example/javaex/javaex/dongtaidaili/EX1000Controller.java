package com.example.javaex.javaex.dongtaidaili;

import java.lang.reflect.Proxy;

/**
 * 例子： 动态代理--jdk自己的
 **/


public class EX1000Controller {


    public void JDK(){
        //    我们要代理的真实对象
        Student realSubject = new Student();

        //    我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        DynamicProxy handler = new DynamicProxy(realSubject);
        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        StudentAll subject = (StudentAll) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject
                .getClass().getInterfaces(), handler);
        System.out.println(subject.getClass().getName());
        System.out.println( subject.add(2,3,"jdk"));
    }

    public void CJlib(){
        //    我们要代理的真实对象
        Student bookFacade=new Student();
        BookFacadeCglib  cglib=new BookFacadeCglib();
        Student bookCglib=(Student)cglib.getInstance(bookFacade);
        System.out.println( bookCglib.add(1,2,"cjlib"));
    }

    public static void main(String [] a){
        EX1000Controller e = new EX1000Controller();
        e.CJlib();
//        e.JDK();

    }


}
