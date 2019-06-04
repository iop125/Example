package com.example.javaex.javaex.dataStructure.sort;

import java.util.Arrays;

public class ChoiceSort {

    static int[] simpleSelectionSorting(int a[]) {

        //遍历所有的数据
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int weizhi = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    weizhi = j;
                }
            }
            if (i != weizhi) {
                int temp = a[i];
                a[i] = a[weizhi];
                a[weizhi] = temp;
            }

        }
        return a;
    }

    public static void main(String s[]) {
        int[] a1 = new int[]{6, 5, 1, 787, 554, 444, 34345, 23423435, 1, 24, 55};
        System.out.println(Arrays.toString(ChoiceSort.simpleSelectionSorting(a1)));
    }

}
