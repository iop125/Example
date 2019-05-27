package com.example.javaex.javaex.dataStructure.tree.huffmanTree.huffmanCode;

public class HuffmanCodeNode implements Comparable<HuffmanCodeNode> {

    public HuffmanCodeNode leftNode;
    public HuffmanCodeNode rightNode;
    /*
    权值
     */
    public int weight;
    public Byte data;

    public HuffmanCodeNode(Byte data, int weight) {
        this.weight = weight;
        this.data = data;
    }

    @Override
    public int compareTo(HuffmanCodeNode o) {
        return -this.weight + o.weight;
    }

    @Override
    public String toString() {
        return "{" +
                "weight=" + weight +
                ", data=" + data +
                '}';
    }
}
