package com.example.javaex.javaex.dataStructure.tree.cluedBinaryTree;

public class CluedBinaryTree {


    private CluedBinaryNode root;
    /**
     * 前驱节点
     */
    private CluedBinaryNode pre;

    public void setRoot(CluedBinaryNode root) {
        this.root = root;
    }
    //中序线索化二叉树 ---需要递归要遍历所用的节点

    public void threadNodes() {
        threadNodes(root);
    }
    void threadNodes(CluedBinaryNode node) {
        if (node == null) {
            return;
        }
        //处理左子树
        threadNodes(node.leftNode);
        //处理前驱节点
        if (node.leftNode == null) {
            //让当前节点的左指针指向前驱节点
            node.leftNode = pre;
            //改变当前节点左指针的类型 前继节点
            node.leftType = 1;
        }
        //如果上一个节点 的右节点的类型是0
        if(pre !=null&&pre.rightNode==null){
            pre.rightNode = node;
            pre.rightType =1;
        }
        //每处理一个节点，当前节点是下一个节点的前驱节点
        pre =node;
        //处理右子树
        threadNodes(node.rightNode);
    }
     public CluedBinaryNode getRootForValue(int value){
        return  getRoot( root, value);
     }
    CluedBinaryNode getRoot(CluedBinaryNode root,int value){
        CluedBinaryNode returnRoot = null;
         if(root == null){
             return returnRoot;
         }
         if (root.value==value) {
             returnRoot = root;
         }else{
             returnRoot = root.leftType ==0 ?getRoot(root.leftNode, value):null;
             returnRoot = returnRoot==null? root.leftType ==0?getRoot(root.rightNode, value):null:returnRoot;
         }
         return returnRoot;
     }

}
