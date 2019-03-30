package com.example.collection;

/**
 * Created by zhangpan on 2019/3/28.
 */
public class CDemo5 {
     public static void quickSort(int[] arr,int low,int high){
         if(low>=high){
             return;
         }
         int left = low;
         int right = high;
         int i = left;
         int j  = right;
         int key = arr[low];
         while (i<j){
             while (arr[j]>=key && i<j){
                 j--;
             }
             if(key > arr[j]){
                 int temp = arr[j];
                 arr[j] = arr[i];
                 arr[i] = temp;
             }
             while (arr[i]<=key && i<j){
                 i++;
             }
//             if(key < arr[j]){
//                 int temp = arr[j];
//                 arr[j] = arr[i];
//                 arr[i] = temp;
//             }
             if(arr[i]>key){
                 int t = arr[i];
                 arr[i] = arr[j];
                 arr[j] = t;
             }
             if(i>left)
                 quickSort(arr,left,i-1);
             if(j<right)
                 quickSort(arr,j+1,right);

         }


     }

    public static void main(String[] args) {
         int[] a = new int[]{2,1,3,6,5,3,5,4};
        quickSort(a,0,a.length-1);
        for (int t:a ) {
            System.out.println(t);
        }
    }
}
