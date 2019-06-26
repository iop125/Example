package com.example.javaex.javaex.thead.ex_guitusaipao;


import com.example.javaex.javaex.demo.Menber;

/**
 * 兔子每秒0.5米的速度，每跑2米休息10秒，
 */
public class Tuzi extends Animal implements Runnable{
    private Menber menber;
    @Override
    public void run() {
        double lenth = 0;

        try {
            //跑
            while(lenth < 20){
                //其他的跑到终点这边停了
                if(menber.i ==1){
                    System.out.println(lenth + "  乌龟的跑到终点这边停了");
                    Thread.interrupted();
                }
                //每跑2米休息10秒
                if(lenth>0&&lenth%2 ==0){
                    System.out.println(lenth + "  兔子休息10秒");
                    Thread.sleep(10000);
                }
                //兔子每秒0.5米的速度
                lenth = lenth+0.5;
                Thread.sleep(1000);
                System.out.println(lenth + " 兔子跑了1秒");

            }
            //这块赢了。。
            System.out.println("  兔子跑到终点了");
            menber.i=2;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public Tuzi(Menber menber) {
        this.menber = menber;
    }
}
