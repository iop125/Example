package com.jd.test.example.BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean初始化之前"+bean.getClass().getSimpleName());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean初始化之后"+bean.getClass().getSimpleName());
        //为当前对象注册代理监控对象增强能力
        Class beanClass = bean.getClass();
        if (beanClass == ISomeService.class) {
            Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                /**
                 *
                 * @param proxy  代理监控对象
                 * @param method  监控方法执行防范
                 * @param args    方法参数
                 * @return
                 * @throws Throwable
                 */
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("  ISomeService   ");
                    String restule = (String) method.invoke(bean, null);
                    return restule.toUpperCase();
                }
            });
            return proxy;
        }
        return bean;
    }
}
