package com.jd.test.example.beanDI.self;

import java.util.HashMap;
import java.util.Map;

public class BeanDefinedForDI {

    private String beanId;
    private String classPath;
    private String scope="singleton";
    private String factoryBean;
    private String factoryMethod;
    private Map<String,String> proertyMap = new HashMap<>();


    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getFactoryBean() {
        return factoryBean;
    }

    public void setFactoryBean(String factoryBean) {
        this.factoryBean = factoryBean;
    }

    public String getFactoryMethod() {
        return factoryMethod;
    }

    public void setFactoryMethod(String factoryMethod) {
        this.factoryMethod = factoryMethod;
    }

    public Map<String, String> getProertyMap() {
        return proertyMap;
    }

    public void setProertyMap(Map<String, String> proertyMap) {
        this.proertyMap = proertyMap;
    }
}
