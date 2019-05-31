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

    /**
     * 通过值查找给bTree中的节点
     * @param value
     * @return
     */
    public BTreeNode search(Integer value) {
        if (root == null) {
           return null;
        }
        return root.searchNode(value);
    }
    public static void main(String a[]) {
        BTreeTree btree = new BTreeTree(4);
        int[] array = new int[]{200,100,300,400,600,800,900,850,860,1000,1300,1234,1500,1600,1700};
        for (int i = 0; i < array.length; i++) {
            btree.add(array[i]);
        }
        System.out.println("-----   "+btree.root);
        BTreeNode b = btree.search(1600);
        System.out.println("b -----   "+b);

    }

}
