package com.jd.test.example.Aop_Advice_guwen;

import org.springframework.aop.MethodMatcher;

import java.lang.reflect.Method;

public class MyMethodMatcher implements MethodMatcher {
    @Override
    /**
     * 静态匹配方式--根据方法名称判断
     * 被监控的诶没有重载方法  每个方法名称都是唯一的
     * method：接口中的某一个方法
     * targetClass： 接口中的一个实现类
     * 业务：只想为person类中额eat提供织入服务
     */
    public boolean matches(Method method, Class<?> targetClass) {
        String methodName = method.getName();
        if("eat".equals(methodName)){
            return true;
        }

        return false;
    }

    @Override
    public boolean isRuntime() {
        return false;
    }

    @Override
    /**
     * 动态
     */
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return false;
    }
}
