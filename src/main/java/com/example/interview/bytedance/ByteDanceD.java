/*
package com.example.interview.bytedance;

        import java.util.Scanner;

*/
/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年08月25日 20:00
 * @ModificationHistory:
 *//*

public class ByteDanceD {


    public static boolean function(int a,int b){
        while (b!=0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a>1?true:false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(maxNum(n,arr));
    }

    private static int maxNum(int n, int[] arr) {
        int max = 0;
        int[][] arrNum = new int[n][n];

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(function(arr[i],arr[j])){
                    arrNum[i][j] = 1;
                    arrNum[j][i] = 1;
                }
            }
        }
        return max;
    }


    public static int  function22(int n,int[][] rel){
        int[] flag = new int[n];
        int dy = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(rel[i][j] ==1 ){
                    if(flag[i] == 1 && flag[j] == 1){
                        continue;
                    } else  if(flag[i] == 1 && flag[j] == 0){
                        flag[i] = 1;
                        flag[j] = 1;
                    }else {

                    }
                }
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
    }
}
*/
