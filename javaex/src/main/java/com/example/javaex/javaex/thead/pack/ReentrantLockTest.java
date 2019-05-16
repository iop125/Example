package com.example.javaex.javaex.thead.pack;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest extends Thread {
    public static ReentrantLock lock = new ReentrantLock();
    public static  volatile  int i = 0;

    public ReentrantLockTest(String name) {
        super.setName(name);
    }


    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(this.getName() + " pre");
            Thread.sleep(100);
            System.out.println(this.getName() + " after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest test1 = new ReentrantLockTest("thread1");
        ReentrantLockTest test2 = new ReentrantLockTest("thread2");
        test1.start();
        test2.start();
//        test1.join();
//        test2.join();
        System.out.println(i);

    }
}
