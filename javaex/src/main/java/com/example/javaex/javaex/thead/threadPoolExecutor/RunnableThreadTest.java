package com.example.javaex.javaex.thead.threadPoolExecutor;

public class RunnableThreadTest implements Runnable{


    @Override
    public void run() {
        System.out.println("Runnable-----"+Thread.currentThread().getName());
    }
}
