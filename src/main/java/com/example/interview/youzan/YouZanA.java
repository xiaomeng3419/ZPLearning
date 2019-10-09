package com.example.interview.youzan;

import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年10月08日 19:21
 * @ModificationHistory:
 */
public class YouZanA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();

        int[] arr = new int[m];

        int max = -1;
        int min  = -1;

        if (m == 0){
            System.out.println(0);
            return;
        }
        int step = 0;
        arr[0] = scanner.nextInt();
        int maxPos =0;
        int minPos = 0;
        max = min = arr[0];
        for (int i = 1; i < m; i++) {
            arr[i] = scanner.nextInt();
            if(max<arr[i]){
                max = arr[i];
                maxPos = i;
            }
            if(min>arr[i]){
                min = arr[i];
                minPos = i;
            }
        }

        while (max-min>1){
            max = arr[maxPos] = arr[maxPos]-1;
            min = arr[minPos] = arr[minPos]+1;
            for (int i = 1; i < m; i++) {
                if(max<arr[i]){
                    max = arr[i];
                    maxPos = i;
                }
                if(min>arr[i]){
                    min = arr[i];
                    minPos = i;
                }
            }
            step++;

        }
        System.out.println(step);
    }
}
