package com.example.javaex.javaex.suo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;


public class Lock2 {
    /**
     * 可以调用硬件
     */
    static Unsafe unsafe = null;
    private static long valueOffset;
    volatile int i = 0;

    static {
        //不能直接用的可以用反射
//        unsafe = Unsafe.getUnsafe();
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
            //目标：通过unsafe去调用底层硬件源语
            //
            valueOffset = unsafe.objectFieldOffset(Lock2.class.getDeclaredField("i"));//cas 操作
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用cas去修改i的值
     */
    public void add() {
        int c;
        do {
            c = unsafe.getIntVolatile(this, valueOffset);
            //获取最新的值
            System.out.println("-------"+i);
        } while (!unsafe.compareAndSwapInt(this, valueOffset, c, c + 1));
        System.out.println("%%%%%%%%%%%"+i);
    }

    public static void main(String a[]) {
        Lock2 lock1 = new Lock2();
        lock1.add();

    }
}
