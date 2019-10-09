package com.example.interview.bytedance;

import javax.swing.*;
import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年08月25日 19:35
 * @ModificationHistory:
 */
public class ByteDanceC {




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 4;
        int[][] rel = new int[n][n];
        int react = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rel[i][j] = scanner.nextInt();
            }
        }

        calcMap(rel,react);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(rel[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void calcMap(int[][] rel, int react) {
        if (react == 1){
            //向上
            for (int i = 0; i < 4; i++) {
                int[] flag = new int[4];
                int tempIndex = 0;
                for (int j = 0; j < 4; j++) {
                    if(rel[j][i]==0){
                        continue;
                    }
                    if(rel[j][i]== rel[j+1][i]){
                        int temp = 2*rel[j][i];
                        flag[tempIndex] = temp;
                        rel[j+1][i] = 0;
                        tempIndex++;
                    }else {
                        flag[tempIndex] = rel[j][i];
                        if(tempIndex != j){
                            rel[j][i] =0;
                        }
                        tempIndex++;
                    }

                }

                for (int j = 0; j < 4; j++) {
                    rel[j][i] = flag[j];
                }
            }
        }


        if (react == 3){
            //向左
            for (int i = 0; i < 4; i++) {
                int[] flag = new int[4];
                int tempIndex = 0;
                for (int j = 0; j < 4; j++) {
                    if(rel[i][j]==0){
                        continue;
                    }
                    if(rel[i][j]== rel[i][j+1]&&j<3){
                        int temp = 2*rel[i][j];
                        flag[tempIndex] = temp;
                        rel[i][j+1] = 0;
                        tempIndex++;
                    }else {
                        flag[tempIndex] = rel[i][j];
                        tempIndex++;
                    }

                }


                for (int j = 0; j < 4; j++) {
                    rel[i][j] = flag[j];
                }
            }
        }

        if (react == 4){
            //向右
            for (int i = 3; i >=0; i--) {
                int[] flag = new int[4];
                int tempIndex = 3;
                for (int j = 3; j >= 0; j--) {
                    if(rel[i][j]==0){
                        continue;
                    }
                    if(rel[i][j]== rel[i][j-1]&&j>0){
                        int temp = 2*rel[i][j];
                        flag[tempIndex] = temp;
                        rel[i][j-1] = 0;
                        tempIndex--;
                    }else {
                        flag[tempIndex] = rel[i][j];
                        tempIndex--;
                    }

                }


                for (int j = 0; j < 4; j++) {
                    rel[i][j] = flag[j];
                }
            }
        }


        if (react == 2){
            //向上
            for (int i = 3; i >=0; i--) {
                int[] flag = new int[4];
                int tempIndex = 3;
                for (int j = 3; j >= 0; j--) {
                    if(rel[j][i]==0){
                        continue;
                    }
                    if(rel[j][i]== rel[j-1][i]){
                        int temp = 2*rel[j][i];
                        flag[tempIndex] = temp;
                        rel[j-1][i] = 0;
                        tempIndex--;
                    }else {
                        flag[tempIndex] = rel[j][i];
                        tempIndex--;
                    }

                }
                for (int j = 0; j < 4; j++) {
                    rel[j][i] = flag[j];
                }
            }
        }


    }
}
