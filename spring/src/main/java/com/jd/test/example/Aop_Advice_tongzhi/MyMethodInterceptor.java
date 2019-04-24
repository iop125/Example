package com.jd.test.example.Aop_Advice_tongzhi;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ThrowsAdvice;

/**
 * 环绕通知
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("------环绕前  ");
        invocation.proceed();
        System.out.println("------环绕后  ");
        return null;
    }
}
