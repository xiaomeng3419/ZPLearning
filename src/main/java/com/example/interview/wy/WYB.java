package com.example.interview.wy;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年08月03日 15:54
 * @ModificationHistory:
 */
public class WYB {
    private static int s = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();
        for (int i = 0; i < group ; i++) {
            int n = sc.nextInt();
            long[] item = new long[n+2];
            if(n<3){
                System.out.println("NO");
                continue;
            }
            for (int j = 0; j < n; j++) {
               item[j+1] =  sc.nextLong();
            }
            item[0] = item[n];
            item[n+1] = item[n];
            boolean flag = true;
            for (int j = 1; j < n+1; j++) {
                if(item[j]>item[j-1]+item[j+1]){
                    flag = false;
                    break;
                }
            }
            System.out.println(flag?"YES":"NO");
        }
    }
}
