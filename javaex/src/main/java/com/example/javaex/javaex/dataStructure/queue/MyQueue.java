package com.example.javaex.javaex.dataStructure.queue;

import java.util.EmptyStackException;

/**
 *
 */
public class MyQueue {
    int[] elements;

    public MyQueue() {
        this.elements = new int[0];
    }

    /**
     * 入队
     * @param i
     */
    void add(int i) {
        int[] element = new int[this.elements.length + 1];

        for (int n = 0; n < elements.length ; n++) {
            element[n] = elements[n];
        }
        element[this.elements.length] = i;
        elements = element;
    }

    /**
     * 出队
     * @return
     */
    int poll() {
        if(this.elements.length ==0)  throw new EmptyStackException();
        int returnValue = elements[0];
        int[] element = new int[this.elements.length - 1];
        for (int n = 0; n < element.length; n++) {
            element[n] = elements[n+1];
        }
        this.elements =element;
        return returnValue;
    }
    int get(int i) {
        if(this.elements.length ==0)  throw new EmptyStackException();

        return elements[0];
    }
    public  static void main(String [] a){
        MyQueue myQueue = new MyQueue();
        myQueue.add(3);
        myQueue.add(5);
        myQueue.add(7);
        myQueue.add(10);
        myQueue.add(19);
        System.out.println(myQueue.get(0));
        System.out.println(myQueue.poll());
        System.out.println(myQueue.get(0));
    }
}
