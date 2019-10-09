package com.example.interview.wy;

import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年08月03日 16:33
 * @ModificationHistory:
 */
public class WYD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int var = sc.nextInt();
            int count = 0 ;
            for (int j = 0; j < n ; j++) {
                if(arr[j]>=var){
                    count = n-j;
                }
            }
            System.out.println(count);
        }
    }
}
