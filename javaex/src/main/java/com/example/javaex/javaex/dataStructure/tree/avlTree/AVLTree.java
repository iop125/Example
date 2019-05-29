package com.example.javaex.javaex.dataStructure.tree.avlTree;

public class AVLTree {
    public AVLNode root;

    public static void main(String[] a) {
        int[]
        array = new int[]{9, 6, 10, 4, 3};//左
        array = new int[]{50,40,80,90,100};//右
        array = new int[]{8,5,9,4,6,7};//左右
        array = new int[]{8,5,20,13,22,16};//右左
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < array.length; i++) {
            avlTree.add(new AVLNode(null, null, array[i]));
        }
        avlTree.printlnTree();
        System.out.println(avlTree.root.hight());
        System.out.println(avlTree.root.lefeHeight() - avlTree.root.rightHeight());
    }

    public void add(AVLNode node) {
        if (root == null) {
            root = node;
            return;
        }
        root.addNode(node);
    }

    void printlnTree() {
        root.printlnTree();
    }

}
