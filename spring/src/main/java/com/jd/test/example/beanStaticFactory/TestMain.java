package com.jd.test.example.beanStaticFactory;


import com.jd.test.domain.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {

        ApplicationContext factory = new ClassPathXmlApplicationContext("spring_config.xml");
        Teacher t = (Teacher) factory.getBean("teacher");
        System.out.println("t=" + t);

    }

}
