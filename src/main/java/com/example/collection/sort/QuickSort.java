package com.example.collection.sort;

/**
 * Created by zhangpan on 2019/2/22.
 */
public class QuickSort {
    public static void quickSort(int[] arr,int low,int high){
        if(arr.length==0){
            return;
        }
        int temp = arr[low];
        int end = high;
        int start = low;

       while (end>start){
           //从后往前
           while (end>start&&arr[end]>=temp){
               end--;
           }
           if(arr[end]<temp){
               int t = arr[end];
               arr[end] = arr[start];
               arr[start] = t;

           }
            //从前往后
           while (end>start&&arr[start]<=temp){
               start++;
           }
           if(arr[start]>temp){
               int t = arr[start];
               arr[start] = arr[end];
               arr[end] = t;
           }

           if(start>low) quickSort(arr,low,start-1);//左边序列。第一个索引位置到关键值索引-1
           if(end<high) quickSort(arr,end+1,high);//右边序列。从关键值索引+1到最后一个


       }

    }
    public void sort(int[] a,int low,int high){
        int start = low;
        int end = high;
        int key = a[low];


        while(end>start){
            //从后往前比较
            while(end>start&&a[end]>=key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while(end>start&&a[start]<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if(start>low) sort(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<high) sort(a,end+1,high);//右边序列。从关键值索引+1到最后一个
    }

    public static void main(String[] args) {
//        int a[] = {3,1,5,7,2,4,9,6};
        int a[] = {2,1,3,6,5,3,5,4};
        quickSort(a,0,a.length-1);
        SimpleSelectSort.printResult(a,a.length);
    }

}
