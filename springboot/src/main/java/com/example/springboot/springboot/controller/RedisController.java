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
@RequestMapping("redisController")
public class RedisController {




    @RequestMapping("/addaatest2")  //提供“路由”的信息
    public String addAatest2() {

        return "page/index";
    }

}
