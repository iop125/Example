package com.jd.test.example.DyNamicFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFatory {

    private List<BeanDefined> beanDefinedList;
    private Map<String, Object> springIoc;


    public BeanFatory(List<BeanDefined> beanDefinedList) throws Exception {
        this.beanDefinedList = beanDefinedList;
        this.springIoc = new HashMap<>();//所有scope="singleton"的对象
        for (BeanDefined defined : beanDefinedList) {
            if ("singleton".equals(defined.getScope())) {
                Class classFile = Class.forName(defined.getClassPath());
                Object o = classFile.newInstance();
                springIoc.put(defined.getBeanId(), o);

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
        Object instance;
        for (BeanDefined beanObj : beanDefinedList) {
            if (beanId.equals(beanObj.getBeanId())) {
                String scope = beanObj.getScope();
                if ("prototype".equals(scope)) {
                    String classPath = beanObj.getClassPath();
                    Class classFile = Class.forName(classPath);
                    //在默认情况下，Spring工厂是通过调用当前类默认工作方法创建实例对象
                    instance = classFile.newInstance();
                } else if ("singleton".equals(scope)) {
                    return springIoc.get(beanObj.getBeanId());
                } else {
                    String classPath = beanObj.getClassPath();
                    Class classFile = Class.forName(classPath);
                    //在默认情况下，Spring工厂是通过调用当前类默认工作方法创建实例对象
                    instance = classFile.newInstance();
                }
                return instance;
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
