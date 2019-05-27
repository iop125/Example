package com.example.javaex.javaex.dataStructure.tree;

import com.example.javaex.javaex.dataStructure.tree.cluedBinaryTree.CluedBinaryNode;
import com.example.javaex.javaex.dataStructure.tree.cluedBinaryTree.CluedBinaryTree;
import com.example.javaex.javaex.dataStructure.tree.huffmanTree.HufffmanNode;
import com.example.javaex.javaex.dataStructure.tree.huffmanTree.HuffmanTree;

public class TestTreeMain {

    public static CluedBinaryTree makeTree() {
        CluedBinaryTree cluedBinaryTree = new CluedBinaryTree();
        CluedBinaryNode cb1 = new CluedBinaryNode();
        cb1.value = 1;
        cluedBinaryTree.setRoot(cb1);
        CluedBinaryNode cb2 = new CluedBinaryNode();
        cb2.value = 2;
        CluedBinaryNode cb3 = new CluedBinaryNode();
        cb3.value = 3;
        CluedBinaryNode cb4 = new CluedBinaryNode();
        cb4.value = 4;
        CluedBinaryNode cb5 = new CluedBinaryNode();
        cb5.value = 5;
        CluedBinaryNode cb6 = new CluedBinaryNode();
        cb6.value = 6;
        cb1.leftNode= cb2;
        cb1.rightNode= cb3;
        cb2.leftNode= cb4;
        cb2.rightNode= cb5;
        cb3.rightNode= cb6;
        return cluedBinaryTree;
    }
    public static void testCluedBinaryTree() {
        CluedBinaryTree cluedBinaryTree = makeTree();
        cluedBinaryTree.threadNodes();
        CluedBinaryNode c= cluedBinaryTree.getRootForValue(5);
//        System.out.println(c.rightNode.value);
        cluedBinaryTree.threadIterate();
    }
    public static void testHuffmanTree() {
       int array[] = new int[]{3,7,8,29,5,11,23,14};
        HufffmanNode huffmanNode = HuffmanTree.init(array);
        System.out.println(huffmanNode.value);
        HuffmanTree HuffmanTree = new HuffmanTree();
        HuffmanTree.hufffmanNode = huffmanNode;
    }



    public static void main(String[] a) {
//        TestTreeMain.testCluedBinaryTree();
        TestTreeMain.testHuffmanTree();
    }
}
