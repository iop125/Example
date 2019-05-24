package com.example.javaex.javaex.Synchronized;

public class SynchronizedMain {


    public static void main(String[] a) {

        SynchronizedTest synchronizedTest1 = new SynchronizedTest();
        SynchronizedTest synchronizedTest2 = new SynchronizedTest();
        Thread t1 = new Thread(new SynchronizedThread(synchronizedTest1,4,"xiancheng1"));
        Thread t2 = new Thread(new SynchronizedThread(synchronizedTest1,4,"xiancheng2"));
        t2.start();

        t1.start();

    }
}
