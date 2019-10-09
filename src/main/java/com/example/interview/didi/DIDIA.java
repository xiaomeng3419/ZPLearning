package com.example.interview.didi;

import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年08月27日 19:42
 * @ModificationHistory:
 */
public class DIDIA {


    public void dicSort(int[] arr,char[] sign,int n){
        for (int i = n-1;i>=0;i++){
            for (int j = i-1;i>=0;i++){
                
            }
        }
        for (int i = 0;i>=0;i--){
            if (sign[i] == '+'|| sign[i] == '-'){
//                if(i<)
            }
        }
    }

    public void swap(int[] arr,int start,int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] operateNum = new int[n];
        char[] sign = new char[n-1];
        int oi = 0;
        int os = 0;
        String line = "";
        line = scanner.nextLine();
        String[] linechars = line.split(" ");
        for (int i = 0;i <2*n-1;i++){
            if(i%2==0){
                operateNum[oi++] = Integer.valueOf(linechars[i]);
            }else {
                sign[os++] = linechars[i].charAt(0);
            }
        }

    }
}
