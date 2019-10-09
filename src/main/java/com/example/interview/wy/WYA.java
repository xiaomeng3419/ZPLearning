package com.example.interview.wy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年08月03日 15:28
 * @ModificationHistory:
 */
public class WYA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n ; i++) {
            score[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {

            int m = sc.nextInt();
            double num  = 0;
            for (int j = 0; j < n; j++) {
                if(score[m-1]>=score[j]){
                    num++;
                }
            }
            num=num*1.0-1;
            BigDecimal decimal = BigDecimal.valueOf(num/n *100);
            System.out.println( String.valueOf(decimal.setScale(6,BigDecimal.ROUND_HALF_DOWN)));
        }
    }
}
