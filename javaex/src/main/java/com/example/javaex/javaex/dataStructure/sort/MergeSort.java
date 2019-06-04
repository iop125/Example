package com.example.javaex.javaex.dataStructure.sort;

import java.util.Arrays;

public class MergeSort {
    static void mergeSort(int a[], int begin, int end) {
        int middle = (begin + end) / 2;
       if(begin<end){
           mergeSort(a, begin, middle);
           mergeSort(a, middle + 1, end);
           merge(a, begin, middle, end);
       }
    }

    static void merge(int a[], int begin, int middle, int end) {
        int[] temp = new int[end - begin + 1];
        int i = begin;
        int j = middle + 1;
        int o = 0;
        while (i <= middle && j <= end) {
            System.out.println(i + "---" + j + "--" + o);
            if (a[i] < a[j]) {
                temp[o] = a[i];
                i++;
            } else {
                temp[o] = a[j];
                j++;
            }
            o++;
        }
        //处理多余的数据
        while (j <= end) {
            temp[o] = a[j];
            j++;
            o++;
        }
        while (i <= middle) {
            temp[o] = a[i];
            i++;
            o++;
        }
        for (int k = 0; k < temp.length; k++) {
            a[k + begin] = temp[k];
        }
    }

    public static void main(String s[]) {
        int[] a1 = new int[]{22, 5, 1, 44, 6, 33};
        MergeSort.mergeSort(a1, 0, a1.length - 1);
        System.out.println(Arrays.toString(a1));
    }


    public int getDuplicate(int[] arr) {
        if (arr == null || arr.length <= 0) {
            System.out.println("数组输入无效！");
            return -1;
        }
        for (int a : arr) {
            if (a < 0 || a > arr.length - 1) {
                System.out.println("数字大小超出范围！");
                return -1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int temp;
            while (arr[i] != i) {
                if (arr[arr[i]] == arr[i])
                    return arr[i];
                // 交换arr[arr[i]]和arr[i]
                temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
            int[] a1 = new int[]{22, 5, 1, 44, 6, 33};

        }
        System.out.println("数组中无重复数字！");
        return -1;
    }
}
