package com.example.interview;

import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年08月17日 20:32
 * @ModificationHistory:
 */
public class Tencent201908B {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[] buildHighs = new int[n];
        int[] seeNums = new int[n];
        for (int i = 0; i < n; i++) {
            buildHighs[i] = sc.nextInt();
        }
        if(n <= 2){
            System.out.println(n);
        }
        int leftSee = 0;
        for (int i = 0; i < n; i++) {
            int left= i -1;
            if(i>=1){
                seeNums[i] = seeNums[i-1];
            }
            //
            int right = i+1;


            if(right>=n){
                continue;
            }
            int rightTemp = buildHighs[i+1];
            while (right<n){
                if(rightTemp<= buildHighs[right]){
                    rightTemp = buildHighs[right];
                    seeNums[i]++;
                }
                right++;
            }
            seeNums[i]++;
        }
        for (int i = 0; i < n ; i++) {
            System.out.print(seeNums[i]+1);
            if(i != n-1){
                System.out.print(" ");
            }
        }
    }
}
