package com.example.javaex.javaex.reflex;

import lombok.Data;


@Data
public class StudentReflex extends StudentAll {

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
