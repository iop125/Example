package com.example.javaex.javaex.dataStructure.tree.BTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreeNode {

    BTreeNode parent;
    List<BTreeNode> ptrs = new ArrayList<>();//指针节点
    List<Integer> informations = new ArrayList<Integer>();//关键字--值

    public BTreeNode(Integer information) {
        if (information != null) {
            this.informations.add(information);
        }
    }

    public BTreeNode() {
    }

    /**
     * @param information 要添加的数据
     * @param m           该树的阶
     */
    public void add(Integer information, int m) {


        if (ptrs == null || ptrs.size() == 0) {
            this.addValue(new BTreeNode(information), m);
            return;
        }
        //若不是叶子节点找到可以添加该关键字的节点添加
        int weizhi = searchWeiZhi(informations, information);
        if (weizhi != -1) {
            if (ptrs.get(weizhi) == null) {
                //TODO 能走么这个直接添加
                this.addValue(new BTreeNode(information), m);
            } else {
                ptrs.get(weizhi).parent = this;
                ptrs.get(weizhi).add(information, m);
                ptrs.get(weizhi).parent = null;
            }
        } else {
            if (ptrs.get(ptrs.size() - 1) == null) {
                //TODO 这个直接添加
                this.addValue(new BTreeNode(information), m);
            } else {
                ptrs.get(ptrs.size() - 1).parent = this;
                ptrs.get(ptrs.size() - 1).add(information, m);
                ptrs.get(ptrs.size() - 1).parent = null;
            }
        }
    }

    public int searchWeiZhi(List<Integer> informations, Integer information) {
        int weizhi = -1;
        for (int i = 0; i < informations.size(); i++) {
            Integer value = informations.get(i);
            if (value >= information) {
                weizhi = i;
                break;
            }
        }
        return weizhi;
    }

    public void addValue(BTreeNode addNode, int m) {
        //在已经找到的大节点中 添加该元素（根节点或者叶子节点）
        this.informations.add(addNode.informations.get(0));
        //对队列排序
        Collections.sort(informations);
        //处理指针
        if (ptrs.size() > 0) {
            int newWeizhi = -1;
            for (int i = 0; i < informations.size(); i++) {
                if (informations.get(i) == addNode.informations.get(0)) {
                    newWeizhi = i;
                    break;
                }
            }
            int n = 0;
            int ptrsLength = this.ptrs.size();//指针节点
            List<BTreeNode> newPtrs = new ArrayList<>();//指针节点
            for (int i = 0; i < ptrsLength + 1; i++) {
                if (i == newWeizhi) {
                    newPtrs.add(addNode.ptrs.get(0));
                } else if (i == newWeizhi + 1) {
                    newPtrs.add(addNode.ptrs.get(1));
                } else {
                    newPtrs.add(this.ptrs.get(n));
                    n++;
                }
            }
            this.ptrs = newPtrs;
        }

        if (informations.size() > m - 1) {
            int zhong = m % 2 == 0 ? m / 2 : m / 2 + 1;
            Integer newBTreeNodeValue = informations.get(zhong - 1);
            BTreeNode newBTreeNode = new BTreeNode(newBTreeNodeValue);
            BTreeNode newBTreeNodeMax = null;
            BTreeNode newBTreeNodemin = null;
            for (int i = 0; i < informations.size(); i++) {
                if (i > zhong - 1) {
                    //生成右树
                    if (newBTreeNodeMax == null) {
                        newBTreeNodeMax = new BTreeNode(informations.get(i));
                    } else {
                        newBTreeNodeMax.add(informations.get(i), m);
                    }
                }
                if (i < zhong - 1) {
                    //生成左树
                    if (newBTreeNodemin == null) {
                        newBTreeNodemin = new BTreeNode(informations.get(i));
                    } else {
                        newBTreeNodemin.add(informations.get(i), m);
                    }
                }
            }
            newBTreeNode.ptrs.add(newBTreeNodemin);
            newBTreeNode.ptrs.add(newBTreeNodeMax);
            //2个子树的节点
            if (this.ptrs.size() > 0) {
                //newBTreeNodemin
                newBTreeNodemin.ptrs = this.ptrs.subList(0, zhong);
                //newBTreeNodeMax
                newBTreeNodeMax.ptrs = this.ptrs.subList(zhong , this.ptrs.size());
            }
            if (this.parent != null) {
                this.parent.addValue(newBTreeNode, m);
            } else {
                this.ptrs=newBTreeNode.ptrs;
                this.informations = newBTreeNode.informations;
            }
        }
    }


    @Override
    public String toString() {
        return "BTreeNode{" +
                "parent=" + parent +
                ", ptrs=" + ptrs +
                ", informations=" + informations +
                '}';
    }
}
