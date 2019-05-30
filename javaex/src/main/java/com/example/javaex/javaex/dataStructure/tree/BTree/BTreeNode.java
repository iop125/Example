package com.example.javaex.javaex.dataStructure.tree.BTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreeNode {

    BTreeNode parent;
    List<BTreeNode> ptrs = new ArrayList<>();//指针节点
    List<Integer> informations = new ArrayList<Integer>();//关键字--值

    public BTreeNode(BTreeNode parent, Integer information) {
        if (information != null) {
            this.informations.add(information);
            this.parent = parent;
        } else {
            this.parent = null;
        }
    }

    /**
     * @param information 要添加的数据
     * @param m           该树的阶
     */
    public void add(Integer information,int m) {
        //先查找 到需要添加的节点

        BTreeNode  bTreeNode  = search( information);




        //在那个节点上添加数据


    }

    public BTreeNode search(Integer information) {
        int weizhi = searchWeiZhi(informations, information);
        if (weizhi == 0) {
            if (ptrs.get(0) == null) {
                return this;
            } else {
                return ptrs.get(0).search(information);
            }
        } else if (weizhi ==  - 1) {
            if (ptrs.get(ptrs.size() - 1) == null) {
                return this;
            } else {
                return ptrs.get(ptrs.size() - 1).search(information);
            }
        } else {
            if (ptrs.get(weizhi) == null) {
                return this;
            } else {
                return ptrs.get(weizhi).search(information);
            }
        }
    }

    public int searchWeiZhi(List<Integer> informations, Integer information) {
        int weizhi = -1;
        for (int i = 0; i < informations.size(); i++) {
            Integer value = informations.get(i);
            if (value >=information) {
                weizhi = i;
                break;
            }
        }
        return weizhi;
    }

    public void addValue(BTreeNode information,int m) {
        this.informations.add(information.informations.get(0));
        Collections.sort(informations);
        if (informations.size() >= m - 1) {
            int zhong = m%2==0?m/2:m/2+1;
            Integer newBTreeNodeValue = informations.get(zhong-1);
            BTreeNode newBTreeNode = new BTreeNode(null, newBTreeNodeValue);
            BTreeNode newBTreeNodeMax = null;
            BTreeNode newBTreeNodemin = null;
            for (int i = 0; i < informations.size() - 1; i++) {
                if (i > zhong-1) {
                    //生成右树
                    if (newBTreeNodeMax == null) {
                        newBTreeNodeMax = new BTreeNode(newBTreeNode, informations.get(i));
                    } else {
                        newBTreeNodeMax.add(informations.get(i),m);
                    }
                }
                if (i < zhong-1) {
                    //生成左树
                    if (newBTreeNodemin == null) {
                        newBTreeNodemin = new BTreeNode(newBTreeNode, informations.get(i));
                    } else {
                        newBTreeNodemin.add(informations.get(i),m);
                    }
                }
            }
            if(this.parent !=null){
                newBTreeNode.ptrs.add(newBTreeNodemin);
                newBTreeNode.ptrs.add(newBTreeNodeMax);
                this.parent.addValue( newBTreeNode, m);
            }else{
                this.ptrs.add(newBTreeNodemin);
                this.ptrs.add(newBTreeNodeMax);
                this.informations.add(information.informations.get(0));
            }
        }
        //新添加的节点要和原有节点重合
        int weizhi = searchWeiZhi( this.informations, information.informations.get(0));
        List<BTreeNode> ptrs = new ArrayList<>();//指针节点
        int ptrsLength = this.ptrs.size();//指针节点
        int n = 0;
        for(int i=0;i< ptrsLength;i++){
            if(i ==weizhi){
                ptrs.add(information.ptrs.get(0));
            }else
            if(i==weizhi+1){
                ptrs.add(information.ptrs.get(1));
            }else{
                ptrs.add(this.ptrs.get(n));
                n++;
            }
        }
    }
}
