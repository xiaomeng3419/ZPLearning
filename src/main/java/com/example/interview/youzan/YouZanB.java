package com.example.interview.youzan;

import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年10月08日 19:36
 * @ModificationHistory:
 */
public class YouZanB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        while (N-->0){
            long n = scanner.nextLong();
            n = n-1;
            long k = (long)Math.sqrt(n*1.0);
            int classfy = 0 ;
            for (long i = 0 ; i <= k+1&&i<n;i++){
                for (int j = 0; j <= i&&i<n ; j++) {
                    if((n == i*j)&&i>1&&j>1){
                        classfy++;
                    }
                }
            }
            System.out.println(classfy);
        }


    }
}
