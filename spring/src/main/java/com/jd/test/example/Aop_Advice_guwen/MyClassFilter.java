package com.jd.test.example.Aop_Advice_guwen;

import org.springframework.aop.ClassFilter;

public class MyClassFilter implements ClassFilter {
    /**
     * 提供织入服务
     * 一个接口下会有很多个实现类
     * 判断当前实现类是不是我们织入的方法的实现类
     * @param clazz  是当前被拦截的对象
     * @return
     */
    @Override
    public boolean matches(Class<?> clazz) {
        if(clazz == DogService.class){
            return true;
        }
        return false;
    }
}
