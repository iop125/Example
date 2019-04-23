package com.jd.test.main;

import com.jd.test.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] a) {
        TestMain testMain =new TestMain();
        testMain.getBean();
    }

    /**
     * 通过配置文件创建类
     */
    public void getBean(){
        ApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");
        Student student = (Student) factory.getBean("student");
        System.out.println(student.getAge());
        System.out.println(student.getTeacher().getTname());
    }
}
