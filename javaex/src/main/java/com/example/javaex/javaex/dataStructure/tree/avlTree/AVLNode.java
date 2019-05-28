package com.example.javaex.javaex.dataStructure.tree.avlTree;

public class AVLNode {

    public AVLNode leftNode;
    public AVLNode rightNode;
    public int value;

    public AVLNode(AVLNode leftNode, AVLNode rightNode, int value) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.value = value;
    }

    public AVLNode() {
    }

    static AVLNode addNode(int[] array) {
        AVLNode avlNOD = null;
        for (int value : array) {
            avlNOD = addNode(avlNOD, value);
        }
        return avlNOD;
    }

    static AVLNode addNode(AVLNode node, int value) {
        if (node == null) {
            node = new AVLNode(null, null, value);
            return node;
        }
        //放在右子节点
        if (node.value < value) {
            if (node.rightNode == null) {
                node.rightNode = new AVLNode(null, null, value);
            } else {
                addNode(node.rightNode, value);
            }
        } else {
            if (node.leftNode == null) {
                node.leftNode = new AVLNode(null, null, value);
            } else {
                addNode(node.leftNode, value);
            }
        }
        //判断是否是一个平衡二叉树
        if (hight(node.leftNode) - hight(node.rightNode) >= 2) {
            //进行y右旋转
            node = rightRotation(node);
        } else {
            //进行左旋转

        }

        return node;
    }

    //当前节点的高度
    static int hight(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(node.leftNode == null ? 0 : hight(node.leftNode), node.rightNode == null ? 0 : hight(node.rightNode)) + 1;
    }


    static void leftRotation(AVLNode node) {

    }

    static AVLNode rightRotation(AVLNode node) {
        //将当前节点复制一个
        AVLNode temporaryNode = new AVLNode(null, null, node.value);
        //将当前节点的右节点
        if (node.rightNode != null) {
            temporaryNode.rightNode = node.rightNode;
        }
        //将其左子节点的右节点赋值给新树的左子节点
        if (node.leftNode != null && node.leftNode.rightNode != null) {
            temporaryNode.leftNode = node.leftNode.rightNode;
        }

        if (node.leftNode != null) {
            node = node.leftNode;
            node.rightNode = temporaryNode;
        }

        return node;
    }

    void printlnTree() {
        printlnTree(this);
    }

    void printlnTree(AVLNode node) {
        if (node == null) {
            return;
        }
        //左
        if (node.leftNode != null) {
            printlnTree(node.leftNode);
        }
        //中
        System.out.println("----" + node.value);
        //右
        if (node.rightNode != null) {
            printlnTree(node.rightNode);
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

    AVLNode p = null;

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

    public static void main(String[] a) {
        int[] array = new int[]{8, 6, 9, 4, 7, 3};
        AVLNode binarySerchTree = AVLNode.addNode(array);
//        binarySerchTree.printlnTree();
//        binarySerchTree.del(5);
        binarySerchTree.printlnTree();
        System.out.println(AVLNode.hight(binarySerchTree.leftNode) - AVLNode.hight(binarySerchTree.rightNode));
    }
}
