package com.example.javaex.javaex.thead.guitusaipao;

import com.example.javaex.javaex.demo.Menber;

/**
 * 乌龟每秒跑0.1米，不休息
 */
public class Wugui implements Runnable {
    private Menber menber;

    @Override
    public void run() {
        double lenth = 0;

        try {
            //跑
            while (lenth < 20) {
                //其他的跑到终点这边停了
                if (menber.i == 2) {
                    System.out.println(lenth + "  兔子的跑到终点这边停了");
                    break;
                }
                //兔子每秒0.5米的速度
                lenth = lenth + 0.1;
                Thread.sleep(1000);
                System.out.println(lenth + " 乌龟跑了1秒");
            }
            //这块赢了。。
            System.out.println("  乌龟乌龟跑到终点了");
            menber.i = 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Wugui(Menber menber) {
        this.menber = menber;
    }
}
