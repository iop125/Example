package com.example.javaex.javaex.dataStructure.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class JishuSort {

    static void radixSort(int[] a) {


        int max = Integer.MIN_VALUE;
        //查找到最大的数
        for (int i : a) {
            if (i > max) {
                max = i;
            }
        }
        //计算最大的数是几位数
        int maxLethong = (max + "").length();
        //用于保存临时变量
        int[][] tempData = new int[10][a.length];
        //放入数组的中位置的数量
        int[] counts = new int[10];
        //根据最大长度比较次数
        for (int l = 0, n = 1; l < maxLethong; l++, n *= 10) {
            for (int i = 0; i < a.length; i++) {
                int yu = a[i] / n % 10;
                tempData[yu][counts[yu]] = a[i];
                counts[yu] = counts[yu] + 1;
            }
            if(l == 0){
                for(int [] tt :tempData){
                    System.out.println(Arrays.toString(tt));
                }
            }
            int index =0;
            for(int k = 0;k<counts.length;k++){
                if(counts[k] !=0){
                    for(int p=0;p<counts[k];p++){
                        a[index]=tempData[k][p];
                        index++;
                    }
                }
                counts[k] = 0;
            }
        }
    }

    public static void main(String s[]) {
        int[] a = new int[]{2, 4, 6, 5, 1,909,89,1022};
        JishuSort.radixSort(a);
        System.out.println(Arrays.toString(a));
    }
}
