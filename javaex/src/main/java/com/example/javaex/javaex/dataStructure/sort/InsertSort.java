package com.example.javaex.javaex.dataStructure.sort;

import java.util.Arrays;

public class InsertSort {


    /**
     * 直接插入排序
     * ，5，8，8，44， 65
     * 从数组第二个开始 ，循环比较数据中第n个和第n-1个元素 若n的数值（zhi_n）小于n-1（zhi_n-1)的数值则数值交换，
     * 交换后判断第n个元素数据的值 若存在前面数据中下标j的值（zhi_j）大于（zhi_n)的情况则将（zhi_j）赋值给j+1位置
     * 最后不存在前面数据大于（zhi_n)的情况，将（zhi_n)的值赋值给前面数组游标位置+1的元素
     *
     * @param a
     */
    public static int[] directInsertion(int[] a) {
        int k = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                int temp2 = a[i];
                a[i] = a[i - 1];
                int j;
                //遍历前面所有数据
                for (j = i - 1; j >= 0 && temp2 < a[j]; j--) {
                    a[j + 1] = a[j];
                    System.out.println(k + "   -  " + Arrays.toString(a));
                    k++;
                }
                a[j + 1] = temp2;
            }
        }
        return a;
    }

    /**
     * 希尔排序
     * 通过步长来处理  步长 = 数据长度/2
     * 比如 数组长度为10
     * 第一轮比较值为  当前元素和 当前元素+步长的做对比   0和5 2和7  一直下下去若 前面>后面则换
     * 第二轮对步长/2 继续 0 ，2，4，6，8 等下去
     * 直到步长 为1 进行比较
     * 步长为0结束
     *
     * @param a
     */
    public static int[] shell(int[] a) {
        int k = 1;
        //遍历所有步长
        for (int buchang = a.length / 2; buchang > 0; buchang = buchang / 2) {
            //遍历步长下数组最后一个元素
            for (int i = buchang; i < a.length; i++) {
                //遍历数组中的值
                for (int j = i - buchang; j >= 0; j -= buchang) {
                    if (a[j] > a[j + buchang]) {
                        int temp = a[j];
                        a[j] = a[j + buchang];
                        a[j + buchang] = temp;

                    }
                }
                System.out.println(k + "     " + Arrays.toString(a));
                k++;
            }
        }
        return directInsertion(a);
    }

    public static void main(String s[]) {
        int[] a = new int[]{6, 5, 1, 787, 554, 64, 6, 456, 45, 64, 63, 4, 2, 34,666666,445,6,34,234,52,65,745,6,24,52,53,6,26,3,634,63,6,34,63,63,56,3,63,6,3,2,5,24,52,52,45,2,52,525,24,5,5245,245,245,0};
        System.out.println(Arrays.toString(InsertSort.directInsertion(a)));
        System.out.println(Arrays.toString(InsertSort.shell(a)));
    }
}
