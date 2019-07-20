package com.example.javaex.javaex.stream;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Data
public class AppleMain {

    public List<Apple> findRed(List<Apple> list, Predicate<Apple> predicate) {
        List<Apple> returnList = new ArrayList<Apple>();
        for (Apple apple : list) {
            if (predicate.test(apple)) {
                returnList.add(apple);
            }
        }
        return list;
    }
    public static void main(String[] a) {
        List<Apple> list = new ArrayList<Apple>();
        //添加数据
        //要判断出红色苹果
        AppleMain appleHandle = new AppleMain();

        List<Apple> returnList2 = appleHandle.findRed(list,
                (Apple apple)  ->   "red".equals(apple.getColour())
        );
        System.out.println(returnList2);
    }
}
