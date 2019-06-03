package com.example.javaex.javaex.dataStructure.Node;

public class Node {
    //节点值
    int data;
    //下个节点
    Node nextNode;

    public Node(int data) {
        this.data = data;
    }
    public void append(Node node) {
        if(this.nextNode == null){
            this.nextNode = node;
        }else{
            this.getNext().append(node);
        }
    }
    public Node getNext() {
        return this.nextNode;
    }
    public static void main(String a []){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.append(node2);
        node1.append(node3);
        System.out.println(node1.getNext().getNext().data);
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

}
