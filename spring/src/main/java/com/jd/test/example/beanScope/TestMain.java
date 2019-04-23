package com.jd.test.example.beanScope;

import com.jd.test.domain.Student;
import com.jd.test.domain.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] a) throws Exception {
        TestMain testMain = new TestMain();
        testMain.doBeanScope();
    }

    /**
     * scope  单例或者多个
     *
     * @throws Exception
     */
    public void doBeanScope() throws Exception {
        BeanDefined beanDefined = new BeanDefined();
        beanDefined.setBeanId("teacher");
        beanDefined.setClassPath("com.jd.test.domain.Teacher");
//        beanDefined.setScope("singleton");
        beanDefined.setScope("prototype");
        List beanList = new ArrayList<>();
        beanList.add(beanDefined);
        //2.声明一个spring提供的beanFactory
        BeanFatory beanFactory = new BeanFatory(beanList);
        beanFactory.setBeanDefinedList(beanList);

        //3。向beanFactory要object
        Teacher teacher1 = (Teacher) beanFactory.getBean("teacher");
        System.out.println(teacher1);
        Teacher teacher2 = (Teacher) beanFactory.getBean("teacher");
        System.out.println(teacher2);

    }


}
