package com.jd.test.example.beanDI;

import com.jd.test.example.beanDI.self.BeanDefinedForDI;
import com.jd.test.example.beanDI.self.BeanFatoryForDI;
import com.jd.test.example.beanDI.self.LessionSelf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {

    public static void main(String[] a) throws Exception {
        TestMain testMain =new TestMain();
//        testMain.getBeanForDI();
        testMain.getBeanForDISelf();
    }

    /**
     * 注入属性
     */
    public void getBeanForDI(){
        ApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");
        Lession student = (Lession) factory.getBean("lession");
        System.out.println(student.toString());
    }

    public void getBeanForDISelf() throws Exception {
        BeanDefinedForDI beanDefinedForDI = new BeanDefinedForDI();
        beanDefinedForDI.setBeanId("lessionSelf");
        beanDefinedForDI.setClassPath("com.jd.test.example.beanDI.self.LessionSelf");

        Map<String,String> map= new HashMap<String,String>();
        map.put("lessionName","sm");
        map.put("timeArray","1s,2s,3s,4s");
        map.put("school","qh,bd,gd");
        beanDefinedForDI.setProertyMap(map);
        List<BeanDefinedForDI> beanDefinedList =new ArrayList<BeanDefinedForDI>();
        beanDefinedList.add(beanDefinedForDI);
        BeanFatoryForDI  beanFatoryForDI = new BeanFatoryForDI(beanDefinedList);
        LessionSelf lession =(LessionSelf) beanFatoryForDI.getBean("lessionSelf");
        System.out.println(lession.toString());

    }
}
