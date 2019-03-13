package com.example.springboot.springboot.controller;


import com.example.springboot.springboot.domain.ex1.CountryDTO;
import com.example.springboot.springboot.domain.ex1.GroupDTO;
import com.example.springboot.springboot.domain.ex1.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 例子： 加载自定义配置文件
 */
@RestController       //注解含义 ：controller里面的方法都以json格式输出  stereotype annotation
@PropertySource(value = "classpath:self.properties", encoding = "utf-8")//注解含义 ：加载自定义的配置文件 有中文要写编码
public class EX1Controller {

    @Value("${city.name}")//注解含义 ：获取配置文件中的参数值
    private String cityName;

    @Autowired
    private StudentDTO studentDTO;
    @Autowired
    private CountryDTO countryDTO;
    @Autowired
    private GroupDTO groupDTO;

    @RequestMapping("/getObectForParm")  //提供“路由”的信息
    public String getObectForParm() {
        return cityName;
    }

    @RequestMapping("/getObectForObject")  //提供“路由”的信息
    public String getObectForObject() {
        //获取配置属性对象
        return studentDTO.toString();
    }
    @RequestMapping("/getObectForList")  //提供“路由”的信息
    public String getObectForList() {
        //获取配置属性对象
        return countryDTO.toString();
    }

    @RequestMapping("/getObectForListObject")  //提供“路由”的信息
    public String getObectForListObject() {
        //获取配置属性对象
        return groupDTO.toString();
    }
}
