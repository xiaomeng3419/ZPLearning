package com.example.collection.sort;

/**
 * Created by zhangpan on 2019/2/20.
 * 直接插入排序
 * 它是把已有的数据排序
 * */
public class InsertSort {
    public static void insertSort(int[] a,int length){
        int i,j,k;
        for (i=1;i<length;i++){
            for (j=i-1;j>=0;j--){
                if(a[j]<a[i]){
                    break;
                }
            }
            System.out.println(j);
            if(j!= i-1){
                for (;j<i;j++){
                    if(a[j]>a[i]){
                        int temp = a[j];
                        a[j] = a[i];
                        a[i] = temp;
                    }
                }
            }

        }

    }
    public static void main(String[] args) {
        int i;
        int[] a = {20,40,30,10,60,50};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        insertSort(a, a.length);

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
