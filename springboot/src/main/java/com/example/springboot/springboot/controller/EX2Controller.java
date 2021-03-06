package com.example.springboot.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 例子： 支持jsp
 * <p>
 * 1。解析器
 * 2。注册webapp资源目录
 **/
// * <resources>
// * 			 <!--注册webapp目录为资源目录-->
// * 			<resource>
// * 				<!-- 指定resources插件处理哪个目录下的资源文件 -->
// * 				<directory>src/main/webapp</directory>
// * 				<!--注意此次必须要放在此目录下才能被访问到-->
// * 				<targetPath>META-INF/resources</targetPath>
// * 				<includes>
// * 					<include>**/*.*</include>
//        *</includes>
//        *</resource>
//        *
//        *</resources>

@Controller     //注解含义 ：controller里面的方法都视图格式输出  stereotype annotation
@RequestMapping("ex2Controller")
public class EX2Controller {

    @RequestMapping("/getJSP")  //提供“路由”的信息
    public String getJSP() {
        System.out.println("----1--");
        return "page/welcom";
    }

}
