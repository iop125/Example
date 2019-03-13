package com.example.springboot.springboot.domain.ex1;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component    //注解含义 ：初始化类
@PropertySource(value = "classpath:self.properties",encoding = "utf-8")
@ConfigurationProperties("group") //注解含义 ：读取那个属性
@Data   //导入依赖：lombok.Data    提供了equals(),hashCode(),toString()方法
public class GroupDTO {

    private List<Users> users;
}
