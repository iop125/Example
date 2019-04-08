package com.example.javaex.javaex.suo;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * 锁原理
 * 1.没有抢到锁  如何让线程挂起等待其他线程释放锁
 * 2.线程锁释放后，如何通知其他线程获取锁
 */
public class Lock3 implements Lock {
    AtomicReference<Thread> owner = new AtomicReference<>();
    LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue();

    @Override
    public void lock() {
        while (!owner.compareAndSet(null, Thread.currentThread())) {//拿到锁
            //没有获取 循环获取 等待其他线程释放锁
            waiters.add(Thread.currentThread());
            //park/unpark  将线程放入停车场
            LockSupport.park();
        }
    }

    @Override
    public void unlock() {
        if (owner.compareAndSet(Thread.currentThread(), null)) {//如果当前线程和锁线程是一个则
            Thread next = null;
            while ((next = waiters.peek()) != null) {
                LockSupport.unpark(next);
            }
        }

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public Condition newCondition() {
        return null;
    }

    /**
     * 调用cas去修改i的值
     */
    public void add() {
       lock();

    }

    public static void main(String a[]) {
        Lock2 lock1 = new Lock2();
        lock1.add();

    }
}
