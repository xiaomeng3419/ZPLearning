package com.example.interview.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangpan on 2019/4/5.
 */
public class T1 {
    public static boolean flag = true;
    public  static int getCoinCount(int m,int n,int[] value){
        int[] var = new int[n];
        int[] result =  new int[n];
        int count = 0;
        if(value.length == 0){
            return -1;
        }
        if(m==0){
            return 0;
        }
        for (int i = m;i>0;i--){
//            int temp = ;
            geiMin(i,n,value,var,result);
            for(int j = 0 ;j < n;j++){
                result[j] = result[j] > var[j] ? result[j]:var[j];
                var[j]=0;
            }
            if(!flag){
                return -1;
            }
        }
        for (int i = 0 ;i < n;i++){
            count +=result[i];
        }
        return count;
    }

    public static  void geiMin(int m,int n,int[] value,int[] var,int[] result){
        int count = 0;
        int temp =m;
        for (int i = n-1;i>=0;i--) {
            if((temp/value[i] )>result[i]){
//                return
//                return;
            }
            temp = temp%value[i];
            if(temp == 0){
                return;
            }
        }

        for (int i = n-1;i>=0;i--){

           if(m/value[i]>0){
               var[i] = m/value[i];
//               System.out.println(var[i]);
//               count+=m/value[i];
           }
            m%=value[i];
            if(m == 0){
                break;
            }
        }
        if(m!=0){
            flag = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m  = scanner.nextInt();
        int n = scanner.nextInt();
        int[] value = new int[n];
        for (int i = 0 ;i < n;i++){
            value[i] = scanner.nextInt();
        }
        Arrays.sort(value);
       /* for (int i = 0 ;i < n;i++){
            System.out.println(value[i]);
        }*/
//        LinkedTransferQueue
        System.out.println(  getCoinCount(m,n,value));
    }
}
