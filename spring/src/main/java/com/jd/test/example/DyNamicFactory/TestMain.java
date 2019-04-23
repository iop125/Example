package com.jd.test.example.DyNamicFactory;

import com.jd.test.domain.Student;
import com.jd.test.domain.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] a) {
        TestMain testMain = new TestMain();
        testMain.doDyNameicFactory();
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
        System.out.println(teacher);

    }


}
