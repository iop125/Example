package com.example.javaex.javaex.dataStructure.tree.binarySearchTree;

import com.example.javaex.javaex.dataStructure.tree.Node;

public class BinarySerchTree {
    public Node root;

    public static void main(String[] a) {
        int[] array = new int[]{7, 3, 1, 5,4,6, 10, 9, 12};
        BinarySerchTree binarySerchTree = new BinarySerchTree();
        binarySerchTree.addNode(array);
//        binarySerchTree.printlnTree();
//        Node node = binarySerchTree.search(binarySerchTree.root, 7);
//        Node nodeP = binarySerchTree.searchP(binarySerchTree.root, 7);
//        Node mrh = binarySerchTree.searchMinForRight( node.rightNode);
        binarySerchTree.del(5);
        binarySerchTree.printlnTree();
    }

    void addNode(int[] array) {
        for (int value : array) {
            addNode(root, value);
        }
    }

    void addNode(Node node, int value) {
        if (node == null) {
            root = new Node(null, null, value);
            return;
        }
        //放在右子节点
        if (node.value < value) {
            if (node.rightNode == null) {
                node.rightNode = new Node(null, null, value);
            } else {
                addNode(node.rightNode, value);
            }
        } else {
            if (node.leftNode == null) {
                node.leftNode = new Node(null, null, value);
            } else {
                addNode(node.leftNode, value);
            }
        }
    }

    /**
     * 中序
     */
    void printlnTree() {
        printlnTree(root);
    }

    void printlnTree(Node node) {
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

    void del(int value) {
        //先查找到这个节点
        Node node = search(root, value);
        Node pnode = searchP(root, value);
        //删除叶子节点
        if (node.leftNode == null && node.rightNode == null) {
            //找到其父节点 删除响应引用
            if (isLeftRoot(node, pnode)==1) {
                pnode.leftNode = null;
            } else if (isLeftRoot(node, pnode)==2) {
                pnode.rightNode = null;
            }else{
                node = null;
            }
        } else { //删除根节点
            if (node.rightNode == null) {
                pnode.leftNode = node.leftNode;
            } else {
                //查找右边最小的一个节点替换该节点  并将最小节点删除
                Node minForRight = searchMinForRight(node.rightNode);
                del(minForRight.value);
                minForRight.rightNode = node.rightNode;
                minForRight.leftNode = node.leftNode;
                if (isLeftRoot(node, pnode)==1) {
                    pnode.leftNode = minForRight;
                } else if (isLeftRoot(node, pnode)==2) {
                    pnode.rightNode = minForRight;
                } else {
                    root = minForRight;
                }
            }
        }
    }

    /**
     * 查询
     *
     * @param node
     * @param value
     * @return
     */
    Node search(Node node, int value) {
        Node nodeRetrun;
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

    Node p = null;

    Node searchP(Node node, int value) {
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

    Node searchMinForRight(Node node) {
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

    int isLeftRoot(Node node, Node pNode) {
        if(pNode == null){
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
