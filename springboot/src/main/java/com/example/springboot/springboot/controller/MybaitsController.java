package com.example.springboot.springboot.controller;

import com.example.springboot.springboot.domain.ex1.Aatest2;
import com.example.springboot.springboot.service.TestMybitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 例子： 集成mybits
 **/

@Controller     //注解含义 ：controller里面的方法都视图格式输出  stereotype annotation
@RequestMapping("mybaitsController")
public class MybaitsController {

    @Autowired
    private TestMybitasService testMybitasService;

    @RequestMapping("/toAddaatest2")  //提供“路由”的信息
    public String toAddaatest2() {

        return "page/index";
    }
    @RequestMapping("/addaatest2")  //提供“路由”的信息
    public String addAatest2(Aatest2 aatest2) {
        System.out.println(aatest2.toString());

        testMybitasService.add(aatest2);
        return "page/index";
    }


    public static void main(String[] a) {
        System.out.println("----1--");
    }


}
