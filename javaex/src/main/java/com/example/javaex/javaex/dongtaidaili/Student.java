package com.example.javaex.javaex.dongtaidaili;

import lombok.Data;

/**
 * 例子： 动态代理
 **/

@Data
public class Student implements StudentAll{

    private String s;

    @Override
    public int add(int i, int a,String s ) {
        System.out.println("方式： "+s);
        return i+a;
    }
}
