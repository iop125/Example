package com.example.javaex.javaex.thead;

import com.example.javaex.javaex.demo.Menber;

/**
 * 奇偶输出 2个线程一个输出基数一个输出偶数
 */
public class Jioushu implements Runnable {

    private Menber menber;
    private int i;

    @Override
    public void run() {
        while (true) {
            synchronized (menber) {
                if (menber.i < 0) break;
                if (!menber.isShuangshu && i == 0) {
                    menber.isShuangshu = true;
                } else if (menber.isShuangshu && i == 1) {
                    menber.isShuangshu = false;
                }
                System.out.println(menber.i);
                menber.i--;
            }

        }
    }


    public Jioushu(Menber menber, int i) {
        this.menber = menber;
        this.i = i;
    }

    public static void main(String[] a) {
        Menber menber = new Menber(100);
        Thread t1 = new Thread(new Jioushu(menber, 0));
        Thread t2 = new Thread(new Jioushu(menber, 1));
        t1.start();
        t2.start();
    }
}
