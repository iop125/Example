package com.example.javaex.javaex.thead;

import com.example.javaex.javaex.demo.Menber;

/**
 * 2个窗口买票
 */
public class Maipiao implements Runnable {

    private Menber menber;
    private String name;

    @Override
    public void run() {
        while (true) {
            synchronized (menber) {
                if (menber.i == 0) {
                    System.out.println(name + "票买完了");
                    break;
                }
                System.out.println(name + "卖出第" + menber.i + "张票");
                --menber.i;
            }
        }

    }


    public Maipiao(Menber menber, String name) {
        this.menber = menber;
        this.name = name;
    }

    public static void main(String[] a) {
        Menber menber = new Menber(100);
        Thread t1 = new Thread(new Maipiao(menber, "第一窗口"));
        Thread t2 = new Thread(new Maipiao(menber, "第二窗口"));
        t1.start();
        t2.start();
    }
}
