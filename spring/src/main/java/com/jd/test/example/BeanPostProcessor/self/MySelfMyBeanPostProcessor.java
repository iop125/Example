package com.jd.test.example.BeanPostProcessor.self;

import org.springframework.beans.BeansException;

public interface MySelfMyBeanPostProcessor {

    default Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }


    default Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }
}
