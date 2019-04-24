package com.jd.test.example.Aop_Advice_guwen;

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
     * AOP--顾问
     *  可以动态的方法织入切面
     * @throws Exception
     */
    public void doAop() {

        ApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");
        AnimalService AnimalService = (AnimalService)factory.getBean("dogProxy");
        AnimalService.eat();

    }
}
