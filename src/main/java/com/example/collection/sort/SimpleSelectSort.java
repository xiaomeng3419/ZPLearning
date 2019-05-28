package com.example.collection.sort;

/**
 * Created by zhangpan on 2019/2/21.
 */
public class SimpleSelectSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {3,1,5,7,2,4,9,6};
        new SimpleSelectSort().simpleSelectSort(a);
        printResult(a,a.length);
    }


    public void  simpleSelectSort(int[] arr){
        for (int i =0;i<arr.length;i++){
            for (int j = i+1 ;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    arr[j] = arr[i]+arr[j];
                    arr[i] = arr[j]-arr[i];
                    arr[j] = arr[j]-arr[i];
                }
            }
        }
    }
    public static void printResult(int[] a, int n){
        System.out.print("最终排序结果：");
        for(int j=0;j<n;j++){
            System.out.print(" "+a[j]);
        }
        System.out.println();
    }

}
