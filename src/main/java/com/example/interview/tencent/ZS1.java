package com.example.interview.tencent;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangpan on 2019/4/9.
 */
public class ZS1 {
    public static BigDecimal getMax(int n,int minG,int minB,int w){
        BigDecimal var = new BigDecimal(minB/2.0>minG?minG:minB/2.0);
        BigDecimal big = var.multiply(new BigDecimal(3*n));
        BigDecimal war = new BigDecimal(w);
        int c = big.compareTo(war);
        if(c==0){
            return big.setScale(6);
        }else if(c>0) {
            return war.setScale(6);
        }else {
            return big.setScale(6);
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] arr = new int[n*2];
        int minG = Integer.MAX_VALUE;int minB = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0;i<n*2;i++){
            arr[i] = sc.nextInt();
            if(arr[i] == 0){
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println(0);
        }else {
            Arrays.sort(arr);
            for (int i = 0;i<2*n;i++){
                if(i<n){
                    minG = minG<arr[i]?minG:arr[i];
                }else {
                    minB = minB<arr[i]?minB:arr[i];
                }
            }
            System.out.println(getMax(n,minG,minB,w));
        }
    }
}
