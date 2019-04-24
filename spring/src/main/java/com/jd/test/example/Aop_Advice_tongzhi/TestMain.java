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

}
