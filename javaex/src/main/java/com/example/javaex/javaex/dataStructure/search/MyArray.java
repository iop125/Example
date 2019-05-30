package com.example.javaex.javaex.dataStructure.search;


public class MyArray {
    /**
     * 二分法查找
     * 查询有序的数据  从中间开始找 若不等开在左边还是右边
     * 在右边继续 从中间找
     */
    public static int binarySearch(int [] arr,int targer){
        int end = arr.length-1;
        int begin =0;
        int mid =(begin+end)/2;
        int i =-1;
       while(true){
           int num = arr[mid] ;
           if(num ==targer){
               System.out.println("找到了 ====="+mid);
               break;
           }
           if(num<targer){
               begin = mid;
               mid =(begin+end)/2;
           }else{
               end = mid;
               mid =(begin+end)/2;
           }
           if(end <= begin){
               break;
           }
       }
       return i;
    }

    public static int lineSearch(int [] arr,int targer ){
        int num=-1;
      for(int i = 0;i<arr.length-1;i++){
          if(targer == arr[i]){
              num =i;
              break;
          }
      }
      return num;
    }
    public static void main(String s[]){
        MyArray.binarySearch(new int[]{1,3,4,7,8,9,10,20,29,34},0);

        System.out.println("找到了 ====="+ MyArray.binarySearch(new int[]{1,3,4,7,8,9,10,20,29,34},0));
        System.out.println("找到了 ====="+ MyArray.lineSearch(new int[]{1,3,4,7,8,9,10,20,29,34},0));
    }
}
