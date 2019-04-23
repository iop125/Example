package com.jd.test.example.Aop_Advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeAdvice implements MethodBeforeAdvice {
    @Override

    /**  //切面次要业务
     *
     */
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("切面次要业务------xishou ---------");
    }
}
