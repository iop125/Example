package com.jd.test.example.Aop_Advice_tongzhi;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class MyAfterThrowingAdvice implements ThrowsAdvice {
    /**
     * 执行方法的时候 抛出异常时会，，，
     * @param m
     * @param os
     * @param target
     * @param e
     */
    public void afterThrowing(Method m, Object[] os, Object
            target, Exception e) {
        System.out.println("出大事了" + e.getMessage());
    }


}
