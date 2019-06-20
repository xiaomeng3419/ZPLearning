package com.example.collection;

import com.example.collection.reflect.String;

/**
 * Created by zhangpan on 2019/3/15.
 */
public class CDemo2 {
    public static void main(String[] args) {
        int[] arr = {1,5,6,8,7,2,3,4,9};
        //调用堆排序数组
        heapsort(arr);
        //输出排序后的数组
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+"  ");
        }
    }

    public static void heapsort(int[] arr){
        int length = arr.length-1;
        for(int i = (length-1)/2;i>=0;i--){
            heap(arr,i,length);
        }
        for(int i = length;i>0;i--){
            swap(arr,0,i);
            heap(arr,0,i-1);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp ;
    }


    private static void heap(int[] arr,int parent,int length) {
        int temp = arr[parent];
        for (int i = 2*parent+1;i<=length; i=2*i+1){
            if(i<length&&arr[i]<arr[i+1]){;
                i++;
            }
            if(temp>=arr[i]){
                break;
            }
            //父亲节点小于孩子节点，这里就是把最大的推上去
            arr[parent] = arr[i];
            parent = i;
        }
        arr[parent] = temp;
    }

//    public static void heap
}
