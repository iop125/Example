package com.jd.test.example.DyNamicFactory;

import com.jd.test.domain.Teacher;
import com.jd.test.example.DyNamicFactory.self.BeanDefined;
import com.jd.test.example.DyNamicFactory.self.BeanFatory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] a) throws Exception {
        TestMain testMain = new TestMain();
//        testMain.doDyNameicFactory();
//        testMain.doDyNameicFactorySelf();
        testMain.doDyNameicFactoryByStatic();
    }

    /**
     * 针对不同情况选择不同的工厂类进行创建
     * 需要注册工厂
     *
     * @throws Exception
     */
    public void doDyNameicFactory() {
        ApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");
        Teacher teacher = (Teacher) factory.getBean("teacher1");
        Teacher teacher2 = (Teacher) factory.getBean("teacher2");
        System.out.println(teacher);
        System.out.println(teacher2);

    }
    /**
     * 针对不同情况选择不同的工厂类进行创建
     * 需要注册工厂
     *
     * @throws Exception
     */
    public void doDyNameicFactorySelf() throws Exception {
        BeanDefined beanDefined = new BeanDefined();
        beanDefined.setBeanId("teacher");
        beanDefined.setClassPath("com.jd.test.domain.Teacher");
//        beanDefined.setScope("singleton");
        beanDefined.setScope("prototype");
        beanDefined.setFactoryBean("teacher2Fatory");
        beanDefined.setFactoryMethod("createTeacher");
        BeanDefined beanDefinedFactory = new BeanDefined();
        beanDefinedFactory.setBeanId("teacher2Fatory");
        beanDefinedFactory.setClassPath("com.jd.test.example.DyNamicFactory.Teacher2Fatory");
        beanDefinedFactory.setScope("singleton");

        List beanList = new ArrayList<>();
        beanList.add(beanDefined);
        beanList.add(beanDefinedFactory);
        //2.声明一个spring提供的beanFactory
        BeanFatory beanFactory = new BeanFatory(beanList);
        beanFactory.setBeanDefinedList(beanList);

        //3。向beanFactory要object
        Teacher teacher1 = (Teacher) beanFactory.getBean("teacher");
        System.out.println(teacher1);
    }

    /**
     * 针对不同情况选择不同的工厂类进行创建
     * 需要注册工厂
     *
     * @throws Exception
     */
    public void doDyNameicFactoryByStatic() {
        ApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");
        Teacher teacher = (Teacher) factory.getBean("teacher3");
        System.out.println(teacher);

    }

}
