package com.example.interview.bytedance;

import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年08月25日 19:07
 * @ModificationHistory:
 */
public class ByteDanceA {

    public static int calcDY(int[][] rel,int n) {
        int dy = 0;
        int[] flag  = new  int[n];
        for (int i = 0; i < n; i++) {
            flag[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(flag[i] == 1){
                    break;
                }
                if(rel[i][j]>2){
                    if (  flag[i] == 0){
                        dy++;
                        flag[i] = 1;
                        flag[j] = 1;
                    }else {
                        flag[i] = 1;
                        flag[j] = 1;
                    }
                }
            }
            if (flag[i]==0){
                dy++;
            }
        }

        return dy;


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] rel = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rel[i][j] = scanner.nextInt();
            }
        }
        System.out.println(calcDY(rel,n));
    }
}
