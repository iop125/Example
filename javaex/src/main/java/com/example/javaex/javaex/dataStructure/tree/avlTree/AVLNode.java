package com.example.javaex.javaex.dataStructure.tree.avlTree;

public class AVLNode {

    public AVLNode leftNode;
    public AVLNode rightNode;
    public int value;
    public static AVLNode p;

    public AVLNode(AVLNode leftNode, AVLNode rightNode, int value) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.value = value;
    }

    public AVLNode() {
    }


    public void addNode(AVLNode node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.leftNode == null) {
                this.leftNode = node;
            } else {
                this.leftNode.addNode(node);
            }
        } else {
            if (this.rightNode == null) {
                this.rightNode = node;
            } else {
                this.rightNode.addNode(node);
            }
        }
        //判断是否是平衡二叉树
        if (lefeHeight() - rightHeight() >= 2) {
            if(leftNode!= null&&leftNode.lefeHeight()<leftNode.rightHeight()){
                leftNode.leftRotation();
            }
            //右旋转
            this.rightRotation();
        } else if (lefeHeight() - rightHeight() <= -2) {
            if(rightNode!= null&&rightNode.lefeHeight()>rightNode.rightHeight()){
                rightNode.rightRotation();
            }
            this.leftRotation();
        }
    }

    /**
     * 右旋转
     *
     * @return
     */
    public void rightRotation() {
        //创建一个新节点 值为当前节点
        AVLNode temporaryNode = new AVLNode(null, null, value);
        //
        //将当前节点的右子树 赋值给新节点
        if (rightNode != null) {
            temporaryNode.rightNode = rightNode;
        }
        //把新节点的左子树设置为当前节点的左子树的右子树
        temporaryNode.leftNode = leftNode.rightNode;
        //把新节点的左子树设置为当前节点的值
        temporaryNode.value = this.value;
        //当前节点的值替换为左节点的值
        value = leftNode.value;
        //把当前节点的左子树设置成左子树的左子树
        leftNode = leftNode.leftNode;
        //当前右子树 赋值为 新节点
        rightNode = temporaryNode;

    }

    /**
     * 左旋转
     *
     * @return
     */
    void leftRotation() {
        //创建一个新的节点 值是当前节点的值
        AVLNode temporaryNode = new AVLNode(null, null, value);
        //将当前节点的左子树赋值给新节点
        temporaryNode.leftNode = leftNode;
        //把新节点的柚子树设置为当前节点的右节点的左子树
        temporaryNode.rightNode = rightNode.leftNode;
        //当前节点的替换为右节点的值
        value = rightNode.value;
        //把当前节点的右子树设置成右子树的左子树
        rightNode = rightNode.rightNode;
        //当前左子树 赋值为 新节点
        leftNode = temporaryNode;


    }

    int lefeHeight() {
        if (leftNode == null) {
            return 0;
        }
        return leftNode.hight();
    }

    int rightHeight() {
        if (rightNode == null) {
            return 0;
        }
        return rightNode.hight();
    }


    //当前节点的高度
    public int hight(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(node.leftNode == null ? 0 : hight(node.leftNode), node.rightNode == null ? 0 : hight(node.rightNode)) + 1;
    }

    //当前节点的高度
    public int hight() {

        return hight(this);
    }


    void printlnTree() {
        if (this == null) {
            return;
        }
        //左
        if (this.leftNode != null) {
            this.leftNode.printlnTree();
        }
        //中
        System.out.println("----" + this.value);
        //右
        if (this.rightNode != null) {
            this.rightNode.printlnTree();
        }
    }

    AVLNode del(int value) {
        //先查找到这个节点
        AVLNode node = search(this, value);
        AVLNode pnode = searchP(this, value);
        //删除叶子节点
        if (node.leftNode == null && node.rightNode == null) {
            //找到其父节点 删除响应引用
            if (isLeftRoot(node, pnode) == 1) {
                pnode.leftNode = null;
            } else if (isLeftRoot(node, pnode) == 2) {
                pnode.rightNode = null;
            } else {
                node = null;
            }
        } else { //删除根节点
            if (node.rightNode == null) {
                pnode.leftNode = node.leftNode;
            } else {
                //查找右边最小的一个节点替换该节点  并将最小节点删除
                AVLNode minForRight = searchMinForRight(node.rightNode);
                del(minForRight.value);
                minForRight.rightNode = node.rightNode;
                minForRight.leftNode = node.leftNode;
                if (isLeftRoot(node, pnode) == 1) {
                    pnode.leftNode = minForRight;
                } else if (isLeftRoot(node, pnode) == 2) {
                    pnode.rightNode = minForRight;
                } else {
                    return minForRight;
                }
            }
        }
        return this;
    }

    /**
     * 查询
     *
     * @param node
     * @param value
     * @return
     */
    AVLNode search(AVLNode node, int value) {
        AVLNode nodeRetrun;
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return node;
        } else {
            if (node.value > value) {
                nodeRetrun = search(node.leftNode, value);
            } else {
                nodeRetrun = search(node.rightNode, value);
            }
        }
        return nodeRetrun;
    }


    AVLNode searchP(AVLNode node, int value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return null;
        } else {
            p = node;
            if (node.value > value) {
                searchP(node.leftNode, value);
            } else {
                searchP(node.rightNode, value);
            }
        }
        return p;
    }

    AVLNode searchMinForRight(AVLNode node) {
        if (node == null) {
            return null;
        }
        if (node.leftNode != null) {
            return searchMinForRight(node.leftNode);
        }
        if (node.rightNode != null) {
            return searchMinForRight(node.rightNode);
        }
        return node;

    }

    int isLeftRoot(AVLNode node, AVLNode pNode) {
        if (pNode == null) {
            return 0;
        }
        if (pNode.leftNode.value == node.value) {
            return 1;
        }
        if (pNode.rightNode.value == node.value) {
            return 2;
        }
        return 0;
    }
}
