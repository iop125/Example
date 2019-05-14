package com.example.javaex.javaex.thead.threadPoolExecutor;

import java.util.concurrent.ExecutorService;

public class ThreadTestMain {

//    public static int i=1000;

    public static void main(String [] a){

        ThreadPoolExecutorTest threadPoolExecutorTest = new ThreadPoolExecutorTest();
        ExecutorService pool = threadPoolExecutorTest.newCachedThreadPool();

                Thread t1 = new ThreadTest();
                Thread t2 = new ThreadTest();
                pool.submit(t1);
                pool.submit(t2);



        pool.shutdown();
//        System.out.println("---------"+i);

    }
}
