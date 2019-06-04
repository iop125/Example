package com.example.javaex.javaex.dataStructure.sort;

import java.util.Arrays;

/**
 * 交换排序
 */
public class ExchangeSort {
    /**
     * 冒泡排序
     *
     * @param a
     */
    public static int[] maopao(int[] a) {
        //控制标次数
        for (int i = 0; i < a.length - 1; i++) {
            //比较的次数
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    /**
     * 快速排序
     *
     * @param a
     */
    public static int[] quick(int[] a, int start, int end) {
        if(start<end){
            return a;
        }

        //把数组中第start当作基准数
        int startd = a[start];
        //低位数字下标
        int low = start;
        //高位数字下标
        int hight = end;
        //循环找比基本数高的位置
        while (low < hight) {
            //右边比标准数小 不用动
            while (low < hight && a[hight] < startd) {
                hight--;
            }
            a[low] = a[hight];
            //右边比标准数小 不用动
            while (low < hight && a[low] > startd) {
                low++;
            }
            a[hight] = a[low];
        }
        a[low] = startd;
        quick(a, 0, low);
        quick(a, low, a.length-1);
        return a;
    }

    public static void main(String s[]) {
        int[] a = new int[]{2, 4, 6, 5, 1, 67, 1223, 3, 64, 63, 4, 24, 3, 534, 53, 5};
        System.out.println(Arrays.toString(ExchangeSort.maopao(a)));
        System.out.println(Arrays.toString(ExchangeSort.quick(a,0,a.length-1)));
    }
}
