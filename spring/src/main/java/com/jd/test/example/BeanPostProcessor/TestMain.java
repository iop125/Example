package com.jd.test.example.BeanPostProcessor;

import com.jd.test.example.BeanPostProcessor.self.BeanDefined;
import com.jd.test.example.BeanPostProcessor.self.BeanFatory;
import com.jd.test.example.BeanPostProcessor.self.ISomeServiceSelf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] a) throws Exception {
        TestMain testMain = new TestMain();

//        testMain.doBeanPostProcessor();
        testMain.doBeanPostProcessorSelf();
    }

    /**
     * 类增强
     * 需要注册工厂
     *
     * @throws Exception
     */
    public void doBeanPostProcessor() {
        ApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");
        SomeService serviceObject = (SomeService) factory.getBean("isomeService");
        System.out.println(serviceObject.doSome());

    }
    public void doBeanPostProcessorSelf() throws Exception {
        BeanDefined beanDefined = new BeanDefined();
        beanDefined.setBeanId("iSomeServiceSelf");
        beanDefined.setClassPath("com.jd.test.example.BeanPostProcessor.self.ISomeServiceSelf");
        beanDefined.setScope("singleton");

        BeanDefined beanDefinedBeanPostProcessor= new BeanDefined();
        beanDefinedBeanPostProcessor.setBeanId("myBeanPostProcessorSelf");
        beanDefinedBeanPostProcessor.setClassPath("com.jd.test.example.BeanPostProcessor.self.MyBeanPostProcessorSelf");
        beanDefinedBeanPostProcessor.setScope("singleton");

        List beanList = new ArrayList<>();
        beanList.add(beanDefined);
        beanList.add(beanDefinedBeanPostProcessor);
        //2.声明一个spring提供的beanFactory
        BeanFatory beanFactory = new BeanFatory(beanList);
        beanFactory.setBeanDefinedList(beanList);

        //3。向beanFactory要object
        SomeService isomeService = (SomeService) beanFactory.getBean("iSomeServiceSelf");
        System.out.println(isomeService.doSome());
    }

}
