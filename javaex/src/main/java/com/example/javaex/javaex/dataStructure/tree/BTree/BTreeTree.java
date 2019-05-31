package com.example.javaex.javaex.dataStructure.tree.BTree;


public class BTreeTree {

    BTreeNode root;
    int jie;

    public BTreeTree(int jie) {
        this.jie = jie;
    }


    public void add(Integer value) {
        if (root == null) {
            root = new BTreeNode();
        }
        root.add(value, jie);
    }

    public static void main(String a[]) {
        BTreeTree btree = new BTreeTree(3);
        int[] array = new int[]{200,100,300,400,600,800,900,850,860,1000,1300,1234,1500,1600,1700};
        for (int i = 0; i < array.length; i++) {
            System.out.println("-----   "+btree.root);
            btree.add(array[i]);
        }
        System.out.println("-----   "+btree.root);
    }

}
