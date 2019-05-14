package com.example.javaex.javaex.thead.threadPoolExecutor;

public class ThreadTest extends Thread {


    private int i = 10;

    @Override
    public void run() {
        while (i > 0) {
            --i;
            System.out.println(i + "--------" + Thread.currentThread().getName());
        }
    }

}
