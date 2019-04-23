package com.jd.test.example.Aop_Advice;

public class IPersonService implements PersionService{

    volatile String ss;
    @Override
    public void eat() {  //切入点 pointcut  主要业务方法
        System.out.println("chi pao mian");
    }

    @Override
    public void wc() { //切入点 pointcut  主要业务方法
        System.out.println("shang  wc");
    }
}
