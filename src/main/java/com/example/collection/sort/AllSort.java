package com.example.collection.sort;

/**
 * Created by zhangpan on 2019/4/7.
 * 全排序
 */
public class AllSort {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        fullSort(arr, 0, arr.length - 1);
    }

    public static  void  fullSort(int[] arr,int start,int end){

        if (start == end) {
            for (int i : arr) {
                System.out.print(i);
            }
            System.out.println();
            return;
        }
        for (int i = start ;i<=end;i++){
            swap(arr,start,i);
            fullSort(arr,start+1,end);
            swap(arr,start,i);
        }


    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
