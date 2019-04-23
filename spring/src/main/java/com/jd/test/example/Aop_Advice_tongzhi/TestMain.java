package com.jd.test.example.Aop_Advice_tongzhi;

import com.jd.test.example.BeanPostProcessor.SomeService;
import com.jd.test.example.BeanPostProcessor.self.BeanDefined;
import com.jd.test.example.BeanPostProcessor.self.BeanFatory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] a) throws Exception {
        TestMain testMain = new TestMain();

        testMain.doAop();
    }

    /**
     * AOP--通知
     *  接口所有的方法都会有通知--只能对接口中所有的方法织入切面
     * @throws Exception
     */
    public void doAop() {

        ApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");
        PersionService persionProxy = (PersionService)factory.getBean("persionProxy");
        persionProxy.eat();

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
