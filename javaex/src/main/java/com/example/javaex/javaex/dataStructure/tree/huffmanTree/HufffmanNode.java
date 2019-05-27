package com.example.javaex.javaex.dataStructure.tree.huffmanTree;

public class HufffmanNode implements Comparable<HufffmanNode>{

    public HufffmanNode leftNode;
    public HufffmanNode rightNode;
    public int value;

    public HufffmanNode(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(HufffmanNode o) {
        return -this.value+o.value;
    }

    @Override
    public String toString() {
        return "HufffmanNode{" +
                "leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                ", value=" + value +
                '}';
    }
}
