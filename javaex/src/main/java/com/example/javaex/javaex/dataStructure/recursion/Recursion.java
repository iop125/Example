package com.example.javaex.javaex.dataStructure.recursion;

import java.util.ArrayList;
import java.util.List;

public class Recursion {


    private static int getShu(int i){
        if(i  ==1 ||i ==2){
           return 1;
        }else{
            return getShu(i-1)+getShu(i-2);
        }
    }
    //实现斐波那契数列  1，1，2，3，5，8
    public static void ff(int i ){
        int n=1;
        while (true){
            if(n<=i){
                System.out.println( Recursion.getShu(n));
            }else{
                break;
            }
            n++;
        }

    }
    public static void main(String [] a){
        Recursion.ff(10);
    }
}
