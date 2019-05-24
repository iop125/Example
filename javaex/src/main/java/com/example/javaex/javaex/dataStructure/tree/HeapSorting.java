package com.example.javaex.javaex.dataStructure.tree;

import java.util.Arrays;

/**
 * 堆排序是基于完全二叉树的一种排序方式，其中数组可以看成是一个完全二叉树的结构
 * 其中主节点为n 其左子节点为2n  其右子节点为2n+1
 */
public class HeapSorting {


    void heapSorting(int[] array) {
        //开始位置
        int start = (array.length - 1) / 2;
        //结束位置 数组长度-1
        int length = array.length ;
        for (int i = start-1; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
        //交换在把前面的数组在进行大小堆
//        for (int i = length-1; i >= 0; i--) {
//            int temp = array[0];
//            array[0] = array[i];
//            array[i] = temp;
//            maxHeap(array, i, 0);
//        }[182, 88, 74, 10, 79, 5, 9, 3, 2, 8, 8]
    }

    /**
     * 将数组构建大小堆
     *
     * @param array           数组元数据
     * @param size            排序多少个
     * @param lastNonLeafNode 最后一个非叶子节点
     */
    private void maxHeap(int[] array, int size, int lastNonLeafNode) {
        int max = lastNonLeafNode;
        int leftNode = 2 * lastNonLeafNode+1;
        int rightNode = 2 * lastNonLeafNode + 2;
        //和2个子节点对比找出最大的
        if (size >leftNode && array[max] < array[leftNode]) {
            max = leftNode;
        }
        //判断右节点是否大于根节点
        if (size >rightNode && array[max] < array[rightNode]) {
            max = rightNode;
        }
        if (max != lastNonLeafNode) {
            //互换数值
            int temp = array[lastNonLeafNode];
            array[lastNonLeafNode] =  array[max];
            array[max] = temp;
            //若不是叶子节点 可能还要排序  所以递归下去
            maxHeap(array, size, max);
        }
        System.out.println(Arrays.toString(array));

    }

    public static void main(String[] a) {
        HeapSorting HeapSorting = new HeapSorting();
        int[] array = new int[]{10, 8, 9, 2, 8, 5, 74, 3, 88,79,182};
        HeapSorting.heapSorting(array);
    }
}
