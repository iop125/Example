package com.example.javaex.javaex.Synchronized;

import com.sun.source.tree.SwitchTree;

public class SynchronizedThread implements Runnable{

    private SynchronizedTest synchronizedTest;
    private int i;
    private  String a;

    public SynchronizedThread(SynchronizedTest synchronizedTest,int i,String a) {
        this.synchronizedTest = synchronizedTest;
        this.i = i;
        this.a = a;
    }

    @Override
    public void run() {
        try {
        switch(i){
            case 0:synchronizedTest.test(a);break;
            case 1:synchronizedTest.testSynchronizedMethod(a);break;
            case 2:SynchronizedTest.testSynchronizedStaticMethod(a);break;
            case 3:synchronizedTest.testSynchronizedCodeBlockObject(a);break;
            case 4:synchronizedTest.testSynchronizedCodeBlockClass(a);break;
            case 5:synchronizedTest.testSynchronizedCodeBlockAnyObject(a);break;
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
