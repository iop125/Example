package com.example.javaex.javaex.dataStructure.Node;

/**
 * 双向链表
 */
public class LoopNode<E> {

    //节点值
    int data;
    //下个节点
    LoopNode<E> nextNode =this;

    public LoopNode(int data) {
        this.data = data;
    }



    public LoopNode getNext() {
        return this.nextNode;
    }

    public boolean after(LoopNode node) {
        //取出下一个节点作为下下个节点
        node.nextNode = this.nextNode;
        //把下下
        nextNode = node;
        //把新节点作为当前节点的下个节点
        this.nextNode = node;
        return true;
    }



    public static void main(String a[]) {
        LoopNode node1 = new LoopNode(1);
        LoopNode node2 = new LoopNode(2);
        LoopNode node3 = new LoopNode(3);
        LoopNode node4 = new LoopNode(4);
        node1.after(node2);
        node2.after(node3);
        node3.after(node4);
        System.out.println(node1.data);
        System.out.println(node1.nextNode.data);
        System.out.println(node1.nextNode.nextNode.data);
        System.out.println(node1.nextNode.nextNode.nextNode.data);
        System.out.println(node1.nextNode.nextNode.nextNode.nextNode.data);
    }


}
