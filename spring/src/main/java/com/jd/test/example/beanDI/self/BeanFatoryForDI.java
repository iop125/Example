package com.jd.test.example.beanDI.self;

import com.jd.test.example.BeanPostProcessor.self.MySelfMyBeanPostProcessor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class BeanFatoryForDI {

    private List<BeanDefinedForDI> beanDefinedList;
    private Map<String, Object> springIoc;
    private MySelfMyBeanPostProcessor beanPostProcessor;//后置对象

    public BeanFatoryForDI(List<BeanDefinedForDI> beanDefinedList) throws Exception {
        this.beanDefinedList = beanDefinedList;
        this.springIoc = new HashMap<>();//所有scope="singleton"的对象
        for (BeanDefinedForDI defined : beanDefinedList) {
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
                this.beanPostProcessor = (MySelfMyBeanPostProcessor) o;
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
        for (BeanDefinedForDI beanObj : beanDefinedList) {
            if (beanId.equals(beanObj.getBeanId())) {
                String scope = beanObj.getScope();
                String factoryBean = beanObj.getFactoryBean();
                String factoryMethod = beanObj.getFactoryMethod();
                String classPath = beanObj.getClassPath();
                Class classFile = Class.forName(classPath);
                if ("prototype".equals(scope)) {
                    if (factoryBean != null && factoryMethod != null) {
                        Object factoryObject = springIoc.get(factoryBean);
                        Class factoryClass = factoryObject.getClass();
                        Method m = factoryClass.getDeclaredMethod(factoryMethod, null);
                        m.setAccessible(true);
                        instance = m.invoke(factoryObject, null);
                    } else {
                        //在默认情况下，Spring工厂是通过调用当前类默认工作方法创建实例对象
                        instance = classFile.newInstance();
                    }
                } else if ("singleton".equals(scope)) {
                    instance = springIoc.get(beanObj.getBeanId());
                } else {
                    //在默认情况下，Spring工厂是通过调用当前类默认工作方法创建实例对象
                    instance = classFile.newInstance();
                }
                if (beanPostProcessor != null) {
                    proxy = this.beanPostProcessor.postProcessBeforeInitialization(instance, beanObj.getBeanId());
                    setValue(instance, classFile, beanObj.getProertyMap());
                    proxy = this.beanPostProcessor.postProcessAfterInitialization(instance, beanObj.getBeanId());
                    return proxy;
                } else {
                    setValue(instance, classFile, beanObj.getProertyMap());
                    return instance;
                }


            }
        }
        return null;
    }

    /**
     * 注入属性值的简答简单实现
     * @param instance
     * @param classFile
     * @param propertyMap
     * @throws Exception
     */
    private void setValue(Object instance, Class classFile, Map propertyMap) throws Exception {
        //循环遍历  propertyMap <属性名，属性值>
        //在反射赋值
        Method[] methodArray = classFile.getDeclaredMethods();
        Set fieldNameSet = propertyMap.keySet();
        Iterator fieldNameIterator = fieldNameSet.iterator();
        while (fieldNameIterator.hasNext()) {
            String fieldName = (String) fieldNameIterator.next();
            Field fieldObject = classFile.getDeclaredField(fieldName);//获取同名属性对象
            for (Method method : methodArray) {
                String methodName = "set" + fieldName;
                String value = (String) propertyMap.get(fieldName);
                if (methodName.equalsIgnoreCase(method.getName())) {
                    Class filedType = fieldObject.getType();//获取属性类型
                    if (filedType == String.class) {
                        method.invoke(instance, value);
                    } else if (filedType == Integer.class) {
                        method.invoke(instance, Integer.valueOf(value));

                    } else if (filedType == List.class) {
                        List tempList = new ArrayList();
                        String dataArray[] = value.split(",");
                        for (String data : dataArray) {
                            tempList.add(data);
                        }
                        method.invoke(instance, tempList);
                    } else {//fixme   其他的全是数组
                        String dataArray[] = value.split(",");
                        Object data[] = new Object[1];
                        data[0]=dataArray;
                        method.invoke(instance, data);
                    }
                }

            }
        }

    }

}
