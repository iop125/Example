package com.example.javaex.javaex.dataStructure.recursion;

public class Recursion {

    //实现斐波那契数列  1，1，2，3，5，8
    public static int ff(int i){
        if(i  ==1 ||i ==2){
           return 1;
        }else{
            return ff(i-1)+ff(i-2);
        }
    }
    public static void main(String [] a){
        int i=1;
        while (true){
            if(i<10){
               System.out.println( Recursion.ff(i));
            }else{
                break;
            }
            i++;
        }

    }
}
