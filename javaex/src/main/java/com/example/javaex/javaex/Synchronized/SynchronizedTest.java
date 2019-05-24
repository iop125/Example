package com.example.javaex.javaex.Synchronized;

public class SynchronizedTest {

    /**
     * 实例方法
     */
    public synchronized void  testSynchronizedMethod(String a) throws InterruptedException {
//        System.out.println(a+"     testSynchronizedMethod");
        Thread.sleep(3100);
            for(int i=0;i<1;i++){
                System.out.println(a+"     testSynchronizedMethod"+i);
            }
    }
    /**
     * 实例方法
     */
    public  void  test(String a) throws InterruptedException {
//        System.out.println(a+"     test");
        Thread.sleep(3200);
        for(int i=0;i<1;i++){
            System.out.println(a+"     test"+i);
        }
    }

    /**
     * 静态方法
     */
    public synchronized static void  testSynchronizedStaticMethod(String a) throws InterruptedException {

//        System.out.println(a+"     testSynchronizedStaticMethod");
        Thread.sleep(3100);
        for(int i=0;i<1;i++){
            System.out.println(a+"     testSynchronizedStaticMethod"+i);
        }
    }

    /**
     * 代码块中的实例对象
     */
    public void  testSynchronizedCodeBlockObject(String a) throws InterruptedException {
        synchronized(this){
            Thread.sleep(3100);
//            System.out.println(a+"     testSynchronizedCodeBlockObject");
            for(int i=0;i<1;i++){
                System.out.println(a+"     testSynchronizedCodeBlockObject"+i);
            }
        }
    }

    /**
     * 代码块中的class对象
     */
    public void  testSynchronizedCodeBlockClass(String a) throws InterruptedException {
        synchronized(SynchronizedTest.class){
            Thread.sleep(3100);
//            System.out.println(a+"     testSynchronizedCodeBlockClass");
            for(int i=0;i<1;i++){
                System.out.println(a+"     testSynchronizedCodeBlockClass"+i);
            }
        }
    }

    /**
     * 代码块中的any 对象
     */
    public void  testSynchronizedCodeBlockAnyObject(String a) throws InterruptedException {
        String lock="";
        synchronized(lock){
            Thread.sleep(1100);
//            System.out.println(a+"     testSynchronizedCodeBlockAnyObject");
            for(int i=0;i<1;i++){
                System.out.println(a+"     testSynchronizedCodeBlockAnyObject"+i);
            }
        }
    }
}
