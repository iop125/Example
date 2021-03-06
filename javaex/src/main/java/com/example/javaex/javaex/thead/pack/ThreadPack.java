package com.example.javaex.javaex.thead.pack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPack {


    public static void main(String a[]) throws Exception {
//        ThreadPack.countDownLatch();//计数器
//        ThreadPack.cyclicBarrier();
//        ThreadPack.semaphore();//信号量
        ThreadPack.future();//
    }

    /**
     * //等到N减到0，也就说会等到N个线程都执行完
     */
    public static void countDownLatch() throws InterruptedException {
        int N = 10;
        final CountDownLatch latch = new CountDownLatch(N);

        for (int i = 0; i < N; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println("线程 " + Thread.currentThread().getName() + " 执行完毕");
                    //执行完一个线程则latch减一
                    latch.countDown();
                }

            }).start();
        }
        for (int i = 0; i < N; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程 " + Thread.currentThread().getName() + " 执行完毕");
                    //执行完一个线程则latch减一
                    latch.countDown();
                }
            }).start();
        }

        //等到N减到0，也就说会等到N个线程都执行完
        latch.await();
        System.out.println("所有线程都执行完毕,over!!!");
    }

    /**
     * barrier.await()：等到所有parties（线程）都调用
     */
    public static void cyclicBarrier() throws InterruptedException {
        int parties = 5;
//        final CyclicBarrier barrier1 = new CyclicBarrier(parties,new Runnable() {
////
////            @Override
////            public void run() {
////                System.out.println("所有线程执行完毕");
////            }
////        });
        final CyclicBarrier barrier = new CyclicBarrier(parties, () -> System.out.println("所有线程执行完毕"));

        List<Thread> list = new ArrayList<Thread>();

        for (int i = 0; i < parties; i++) {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println("线程 " + Thread.currentThread().getName() + " 准备执行");
                    try {
                        //模拟执行完线程任务
                        Thread.sleep(50);
                        System.out.println("线程 " + Thread.currentThread().getName() + " 执行完毕");
                        barrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            });
            list.add(thread);
            thread.start();
        }
        //wait until done
        for (Thread t : list) {
            t.join();
        }
        System.out.println("主线程继续做其他事情");
    }

    /**
     * 信号量 有标记就可以跑
     */
    public static void semaphore() {
        int permits = 10;

        final Semaphore semaphore = new Semaphore(permits);
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //获得许可
                    try {
                        int availablePermits = semaphore.availablePermits();
                        System.out.println(Thread.currentThread().getName() + " 当前可用资源" + availablePermits);

                        semaphore.acquire();
                        //模拟执行
                        System.out.println(Thread.currentThread().getName() + " 获得许可,正在执行!!!");
                        Thread.sleep(5000);
                        //释放许可
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }

    /**
     * 用来描述一个异步计算的结果。你可以使用isDone方法检查计算是否完成，或者使用get阻塞住调用线程，直到计算完成返回结果
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void future() throws ExecutionException, InterruptedException {
         System.out.println("------");
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(() -> {
            System.out.println("doing");
            Thread.sleep(1000);
            return "done";
        });
        System.out.println(future.get());
    }

    public static void reentrantLock(String a[]) {

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

    }
}
