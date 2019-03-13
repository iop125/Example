package com.example.springboot.springboot.reflex;

import com.miaoyu.test.spring.boot.dongtaidaili.StudentAll;
import lombok.Data;

/**
 * 例子： 动态代理
 **/

@Data
public class StudentReflex implements StudentAll {

    //私有属性
    private String name = "Tom";
    //公有属性
    public int age = 18;



    //私有方法
    private void say() {
        System.out.println("private say()...");
    }

    //公有方法
    public void work() {
        System.out.println("public work()...");
    }

    @Override
    public int add(int i, int a, String s) {
        return 0;
    }
}
