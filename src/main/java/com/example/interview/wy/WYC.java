package com.example.interview.wy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年08月03日 16:12
 * @ModificationHistory:
 */
public class WYC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc .nextInt();
        long[] arrs = new long[n];
        boolean isX = true;//全为奇数
        boolean isY = true;//全为偶数
        for (int i = 0; i < n; i++) {
            arrs[i] = sc.nextLong();
            if (arrs[i]%2 == 0){
                isX = false;
            }else {
                isY = false;
            }
        }
        if((!isX)&&(!isY)){
             Arrays.sort(arrs);
            /*for (int i = 0; i < n; i++) {
                int tempIndx = -1;
                for (int j = i+1; j < n ; j++) {
                    if((arrs[i]+arrs[j])%2 == 1){
                        if(tempIndx!= -1 ){
                            tempIndx = arrs[tempIndx]>arrs[j]?j:tempIndx;
                        }else {
                            tempIndx = j;
                        }
                    }
                }
                if(tempIndx == -1){
                    continue;
                }
                if(arrs[i]>arrs[tempIndx]){
                    continue;
                }
                swap(arrs,i,tempIndx);
            }*/
        }
        for (int i = 0; i < n ; i++) {
            System.out.print(arrs[i]);
            if(i!=n-1)
                System.out.print(" ");
        }
    }

    public static void swap (long[] arrs ,int i,int j){
        long temp  = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }
}
