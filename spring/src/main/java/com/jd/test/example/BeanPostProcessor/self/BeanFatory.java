package com.jd.test.example.BeanPostProcessor.self;

import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFatory {

    private List<BeanDefined> beanDefinedList;
    private Map<String, Object> springIoc;
    private MySelfMyBeanPostProcessor beanPostProcessor;//后置对象

    public BeanFatory(List<BeanDefined> beanDefinedList) throws Exception {
        this.beanDefinedList = beanDefinedList;
        this.springIoc = new HashMap<>();//所有scope="singleton"的对象
        for (BeanDefined defined : beanDefinedList) {
            if ("singleton".equals(defined.getScope())) {
                Class classFile = Class.forName(defined.getClassPath());
                Object o = classFile.newInstance();
                //判断当前对象是否存在后置处理对象
                isProcessor(o, classFile);
                springIoc.put(defined.getBeanId(), o);

            }
        }
    }

    private void isProcessor(Object o, Class classFile) {
        Class interfaceArray[] = classFile.getInterfaces();
        if (interfaceArray == null) {
            return;
        }
        for (int i = 0; i < interfaceArray.length; i++) {
            if (interfaceArray[i] == MySelfMyBeanPostProcessor.class) {
                this.beanPostProcessor = (MySelfMyBeanPostProcessor)o;
            }

        }
    }

    /**
     * 简单的构建beanFactory 创建实例对象
     *
     * @param beanId
     * @return
     * @throws Exception
     */
    public Object getBean(String beanId) throws Exception {
        Object instance = null;
        Object proxy = null;
        for (BeanDefined beanObj : beanDefinedList) {
            if (beanId.equals(beanObj.getBeanId())) {
                String scope = beanObj.getScope();
                String factoryBean = beanObj.getFactoryBean();
                String factoryMethod = beanObj.getFactoryMethod();
                if ("prototype".equals(scope)) {

                    if (factoryBean != null && factoryMethod != null) {
                        Object factoryObject = springIoc.get(factoryBean);
                        Class factoryClass = factoryObject.getClass();
                        Method m = factoryClass.getDeclaredMethod(factoryMethod, null);
                        m.setAccessible(true);
                        instance = m.invoke(factoryObject, null);
                    } else {
                        String classPath = beanObj.getClassPath();
                        Class classFile = Class.forName(classPath);
                        //在默认情况下，Spring工厂是通过调用当前类默认工作方法创建实例对象
                        instance = classFile.newInstance();
                    }
                } else if ("singleton".equals(scope)) {
                    instance = springIoc.get(beanObj.getBeanId());
                } else {
                    String classPath = beanObj.getClassPath();
                    Class classFile = Class.forName(classPath);
                    //在默认情况下，Spring工厂是通过调用当前类默认工作方法创建实例对象
                    instance = classFile.newInstance();
                }
                if(beanPostProcessor !=null){
                    proxy = this.beanPostProcessor.postProcessBeforeInitialization(instance, beanObj.getBeanId());
                    proxy = this.beanPostProcessor.postProcessAfterInitialization(instance, beanObj.getBeanId());
                    return proxy;
                }else{
                    return instance;
                }


            }
        }
        return null;
    }

    public List<BeanDefined> getBeanDefinedList() {
        return beanDefinedList;
    }

    public void setBeanDefinedList(List<BeanDefined> beanDefinedList) {
        this.beanDefinedList = beanDefinedList;
    }

}
