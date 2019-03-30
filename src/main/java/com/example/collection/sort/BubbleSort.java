package com.example.collection.sort;

/**
 * Created by zhangpan on 2019/2/22.
 * 时间复杂度O(n*n),空间复杂度O（1）
 */
public class BubbleSort  {
    public static void bubbleSort(int[] a){
           for (int i = 0;i<a.length-1;i++){
               for (int j = 0;j<a.length-1-i;j++){
                   if (a[j]>a[j+1]){
                       int temp = a[j];
                       a[j] = a[j+1];
                       a[j+1] = temp;
                   }
               }
           }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {3,1,5,7,2,4,9,6};
        new BubbleSort().bubbleSort(a);
        SimpleSelectSort.printResult(a,a.length);
    }

}
