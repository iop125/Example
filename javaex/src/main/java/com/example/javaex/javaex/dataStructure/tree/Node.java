package com.example.javaex.javaex.dataStructure.tree;

public class Node {

    public Node leftNode;
    public Node rightNode;
    public int value;

    public Node(Node leftNode, Node rightNode, int value) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.value = value;
    }

    public Node() {
    }
}
