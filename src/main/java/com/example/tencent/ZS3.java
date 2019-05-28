package com.example.tencent;

import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangpan on 2019/4/9.
 */
public class ZS3 {
    public static int getMaxY(int a,int b){
        if(b==0){
            return a;
        }else {
            return getMaxY(b,a%b);
        }
    }
public static int fun1(int[] arr){
        int count = 0;
        for (int i = 0 ;i<arr.length;i++){
            while (arr[i]!=1){
                count++;
                arr[i]/=2;
            }
        }
        return count;

}
public static int fun2(int[] arr,int var,int sum){
//    System.out.println(var);
//    int weight = var*(int)Math.ceil(arr.length/2.0);
    int weight = sum/arr.length - (sum/arr.length)%var;
//    System.out.println(weight);
//    System.out.println(var);
    int count = 0;
    for (int i = 0 ;i <arr.length;i++){
        if(arr[i] == weight){
            continue;
        }else if(arr[i]>weight) {
            while (arr[i]> weight){
                count++;
                arr[i]=arr[i]/2;
            }
        }else {
            while (arr[i]< weight){
                count++;
                arr[i]=2*arr[i];
            }

        }
    }
    return count;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int war =0;
        int maxY = -1;
        int sum =0;
        for (int i=0;i<n;i++){
            arr[i] =  sc.nextInt();
            sum +=arr[i];
            if(i==0){
                war = arr[0];
            }

            if(i!=0){
                war = getMaxY(war,arr[i]);
            }
        }
        maxY = war;
        if(maxY == 1){
            System.out.println(fun1(arr));
        }else {
            System.out.println(fun2(arr,maxY,sum ));
        }



    }


}
