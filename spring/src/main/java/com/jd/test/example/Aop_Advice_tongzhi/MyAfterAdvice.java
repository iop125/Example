package com.jd.test.example.Aop_Advice_tongzhi;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyAfterAdvice implements AfterAdvice {

    /**  这个存在么  @after
     *
     */
    public void after(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(" 后置------xishou ---------");
    }

}
