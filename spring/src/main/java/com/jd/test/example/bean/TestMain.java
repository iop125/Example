package com.jd.test.example.bean;

import com.jd.test.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] a) throws Exception {
        TestMain testMain =new TestMain();
        testMain.doBean();
    }



    public void doBean() throws Exception {
        //1。注册bean
        BeanDefined beanDefined = new BeanDefined ();
        beanDefined.setBeanId("student");
        beanDefined.setClassPath("com.jd.test.domain.Student");
        List beanList = new ArrayList<>();
        beanList.add(beanDefined);
        //2.声明一个spring提供的beanFactory
        BeanFatory beanFactory = new BeanFatory();
        beanFactory.setBeanDefinedList(beanList);

        //3。向beanFactory要object
        Student student = (Student)beanFactory.getBean("student");
        student.setAge(1111);
    }




}
