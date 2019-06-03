package com.example.javaex.javaex.dataStructure.Node;

public class Node<E> {
    //节点值
    int data;
    //下个节点
    Node<E> nextNode;
    //上个节点
    Node<E> preNode;

    public Node(int data) {
        this.data = data;
    }

    public void append(Node node) {
        if (this.nextNode == null) {
            this.nextNode = node;
            node.preNode = this;
        } else {
            this.getNext().append(node);
        }
    }

    public Node getNext() {
        return this.nextNode;
    }

    public boolean after(Integer value) {
        Node newNextNode = this.nextNode;
        Node newNode = new Node(value);
        newNode.preNode = this;
        newNode.nextNode = newNextNode;
        newNextNode.preNode = newNode;
        this.nextNode = newNode;
        return true;
    }

    public boolean del(Integer value) {
        if (value == null) {
            for (Node<E> x = this; x != null; x = x.getNext()) {
                unlink(x);
                return true;
            }

        } else {
            for (Node<E> x = this; x != null; x = x.getNext()) {
                if (value.equals(x.data)) {
                    //unlink
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    public void show() {
        StringBuffer sb = new StringBuffer();
        for (Node<E> x = this; x != null; x = x.getNext()) {
            sb.append("," + x.getData());
        }
        System.out.println(sb.toString());
    }

    public void afterA(Integer value, Integer findValue) {
        if (findValue == null) {
            for (Node<E> x = this; x != null; x = x.getNext()) {
                if (findValue == x.data) {
                    x.after(value);
                }
            }
        } else {
            for (Node<E> x = this; x != null; x = x.getNext()) {
                if (findValue.equals(x.data)) {
                    x.after(value);
                }
            }
        }
    }

    private void unlink(Node<E> x) {
        Node<E> preNode = x.preNode;
        Node<E> nextNode = x.nextNode;
        if (preNode == null) {
            x.nextNode = nextNode.nextNode;
            x.data = nextNode.data;
        } else {
            preNode.nextNode = nextNode;
            x.preNode = null;
        }

        if (nextNode == null) {
            preNode.nextNode = null;
        } else {
            nextNode.preNode = preNode;
//            x.nextNode = null;
        }
    }

    public static void main(String a[]) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.append(node2);
        node1.append(node3);
        node1.show();
        node1.del(1);
        node1.show();
        node1.after(5);
        node1.show();
        node1.afterA(2, 5);
        node1.show();
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
