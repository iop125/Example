package com.my.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class TestController {

    @RequestMapping("/ss")
    public String ss(){
        System.out.println("----------");
        return "index";
    }
}
