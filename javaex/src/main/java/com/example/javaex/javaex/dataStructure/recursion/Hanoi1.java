package com.example.javaex.javaex.dataStructure.recursion;

public class Hanoi1 {


    /**规律 无论有多少个 都认为只有2个上面的所有盘子和最下面的盘子
     * @param n    有n个盘子
     * @param from 开始的柱子
     * @param in   中间的柱子
     * @param to   目标柱子
     */
    public static void hanoil(int n, String from, String in, String to) {
        //1个直接移动
        if (n == 1) {
            System.out.println("第一个盘子"+from+"  to  "+to);
        }else{
            //移动上面所有的盘子
            hanoil(n-1,  from, to,  in);
            //移动下面的盘子到中间位置
            System.out.println("第"+n+"个盘子"+from+"  to  "+to);
            //把上面的盘子 从中间位置移动到目标位置
            hanoil(n-1,  in, from,  to);
        }
    }
    public static void main(String [] a){
        hanoil(3,"A","B","C");
    }
}
