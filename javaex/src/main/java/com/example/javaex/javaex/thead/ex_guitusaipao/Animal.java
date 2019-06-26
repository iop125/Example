package com.example.javaex.javaex.thead.ex_guitusaipao;

import com.example.javaex.javaex.demo.Menber;

/**
 * 龟兔赛跑 代码  兔子和乌龟跑起来的东西不同  具体逻辑在子类中
 */
public class Animal {

    public double length=20;//比赛的长度


    public  static void main(String a []){
        Menber menber = new Menber();
        Tuzi tuzi =new Tuzi(menber);

        Wugui wugui =new Wugui(menber);
        Thread t1 = new Thread(tuzi);
        Thread t2 = new Thread(wugui);
        t1.start();
        t2.start();
    }


}
