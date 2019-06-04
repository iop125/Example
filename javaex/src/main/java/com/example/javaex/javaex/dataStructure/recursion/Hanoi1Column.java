package com.example.javaex.javaex.dataStructure.recursion;

import java.util.Stack;

public class Hanoi1Column {

    public int name;
    public Stack<Integer> stack = new Stack();

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }

    public Hanoi1Column(int name) {
        this.name = name;
    }

    public void add(int value) {
        for (int n = value; n >= 0; n--) {
            stack.push(n);
        }
    }

}
