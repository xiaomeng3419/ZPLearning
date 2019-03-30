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
           //�Ӻ���ǰ
           while (end>start&&arr[end]>=temp){
               end--;
           }
           if(arr[end]<temp){
               int t = arr[end];
               arr[end] = arr[start];
               arr[start] = t;

           }
            //��ǰ����
           while (end>start&&arr[start]<=temp){
               start++;
           }
           if(arr[start]>temp){
               int t = arr[start];
               arr[start] = arr[end];
               arr[end] = t;
           }

           if(start>low) quickSort(arr,low,start-1);//������С���һ������λ�õ��ؼ�ֵ����-1
           if(end<high) quickSort(arr,end+1,high);//�ұ����С��ӹؼ�ֵ����+1�����һ��


       }

    }
    public void sort(int[] a,int low,int high){
        int start = low;
        int end = high;
        int key = a[low];


        while(end>start){
            //�Ӻ���ǰ�Ƚ�
            while(end>start&&a[end]>=key)  //���û�бȹؼ�ֵС�ģ��Ƚ���һ����ֱ���бȹؼ�ֵС�Ľ���λ�ã�Ȼ���ִ�ǰ����Ƚ�
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //��ǰ����Ƚ�
            while(end>start&&a[start]<=key)//���û�бȹؼ�ֵ��ģ��Ƚ���һ����ֱ���бȹؼ�ֵ��Ľ���λ��
                start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //��ʱ��һ��ѭ���ȽϽ������ؼ�ֵ��λ���Ѿ�ȷ���ˡ���ߵ�ֵ���ȹؼ�ֵС���ұߵ�ֵ���ȹؼ�ֵ�󣬵������ߵ�˳���п����ǲ�һ���ģ���������ĵݹ����
        }
        //�ݹ�
        if(start>low) sort(a,low,start-1);//������С���һ������λ�õ��ؼ�ֵ����-1
        if(end<high) sort(a,end+1,high);//�ұ����С��ӹؼ�ֵ����+1�����һ��
    }

    public static void main(String[] args) {
//        int a[] = {3,1,5,7,2,4,9,6};
        int a[] = {2,1,3,6,5,3,5,4};
        quickSort(a,0,a.length-1);
        SimpleSelectSort.printResult(a,a.length);
    }

}
