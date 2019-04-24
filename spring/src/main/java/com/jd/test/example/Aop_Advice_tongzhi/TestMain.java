package com.jd.test.example.Aop_Advice_tongzhi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] a) {
        TestMain testMain = new TestMain();

        testMain.doAop();
    }

    /**
     * AOP--通知
     * 接口所有的方法都会有通知--只能对接口中所有的方法织入切面
     * 通用的一个通知
     *
     * @throws Exception
     */
    public void doAop() {

        ApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");
        PersionService persionProxy = (PersionService) factory.getBean("persionProxy");
        persionProxy.eat();
//        persionProxy.wc();

    }

}
