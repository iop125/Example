package com.example.javaex.javaex.dataStructure.Node;

public class DoubleNode<E> {
    //节点值
    int data;
    //下个节点
    DoubleNode<E> nextNode = this;
    //上个节点
    DoubleNode<E> preNode = this;

    public DoubleNode(int data) {
        this.data = data;
    }
    public void after(DoubleNode<E> node) {

        DoubleNode<E> nextNext = nextNode;
        //z找到新节点的下个节点
        node.nextNode = nextNext;
        //b把当前节点当作新节点的前一个节点
        node.preNode = this;
        //让原来后一个节点的上一个节点为新节点
        nextNext.preNode = node;
        //把当前的节点的后一个节点设置为新节点
       this.nextNode = node;


    }


    public static void main(String a[]) {
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);
        node1.after(node2);
        node2.after(node3);
        node3.after(node4);
        System.out.println(node1.data);
        System.out.println(node1.nextNode.data);
        System.out.println(node1.nextNode.nextNode.data);
        System.out.println(node1.nextNode.nextNode.nextNode.data);
        System.out.println(node1.nextNode.nextNode.nextNode.nextNode.data);

        System.out.println(node1.nextNode.preNode.data);

        System.out.println(node1.nextNode.nextNode.nextNode.nextNode.nextNode.preNode.data);

    }


}
