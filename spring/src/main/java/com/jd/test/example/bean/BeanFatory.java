package com.jd.test.example.bean;

import java.util.List;

public class BeanFatory {

    private List<BeanDefined> beanDefinedList;

    public List<BeanDefined> getBeanDefinedList() {
        return beanDefinedList;
    }

    public void setBeanDefinedList(List<BeanDefined> beanDefinedList) {
        this.beanDefinedList = beanDefinedList;
    }

    /**
     * 简单的构建beanFactory 创建实例对象
     * @param beanId
     * @return
     * @throws Exception
     */
    public Object getBean(String beanId) throws Exception{
        Object instance;
        for(BeanDefined beanObj:beanDefinedList){
            if(beanId.equals(beanObj.getBeanId())){
                String classPath = beanObj.getClassPath();
                Class classFile= Class.forName(classPath);
                //在默认情况下，Spring工厂是通过调用当前类默认工作方法创建实例对象
                instance= classFile.newInstance();
                return instance;
            }
        }
        return null;
    }


}
