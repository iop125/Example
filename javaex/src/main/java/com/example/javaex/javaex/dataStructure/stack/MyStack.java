package com.example.javaex.javaex.dataStructure.stack;

import java.util.EmptyStackException;

/**
 *
 */
public class MyStack {
    int[] elements;

    public MyStack() {
        this.elements = new int[0];
    }

    void push(int i) {
        int[] element = new int[this.elements.length + 1];

        for (int n = 0; n < elements.length ; n++) {
            element[n] = elements[n];
        }
        element[this.elements.length] = i;
        elements = element;
    }

    int pop() {
        if(this.elements.length ==0)  throw new EmptyStackException();
        int returnValue = elements[elements.length - 1];
        int[] element = new int[this.elements.length - 1];
        for (int n = 0; n < element.length; n++) {
            element[n] = elements[n+1];
        }
        this.elements =element;
        return returnValue;
    }
    int peek() {
        if(this.elements.length ==0)  throw new EmptyStackException();

        return elements[0];
    }
    public  static void main(String [] a){
        MyStack mystack = new MyStack();
        mystack.push(3);
        mystack.push(5);
        mystack.push(7);
        mystack.push(10);
        mystack.push(19);

        System.out.println(mystack.peek());
        mystack.pop();
        System.out.println(mystack.peek());
    }
}
