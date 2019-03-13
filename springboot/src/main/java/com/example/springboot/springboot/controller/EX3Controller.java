package com.example.springboot.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 例子： 集成mybits
 **/

@Controller     //注解含义 ：controller里面的方法都视图格式输出  stereotype annotation
@RequestMapping("ex2Controller")
public class EX3Controller {

    @RequestMapping("/getJSP")  //提供“路由”的信息
    public String getJSP() {
        System.out.println("----1--");
        return "page/welcom";
    }



    public static void main(String [] a){
        System.out.println("----1--");
    }


}
