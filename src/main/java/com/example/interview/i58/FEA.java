package com.example.interview.i58;

import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年10月13日 20:27
 * @ModificationHistory:
 */
public class FEA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long M = scanner.nextLong();
        long N = scanner.nextLong();
        int X = scanner.nextInt();
        int num  = 0;
        for (long i = M; i <= N; i++) {
            long temp = i;
            while (temp!= 0 ){
                int x = (int) temp%10;
                if(x == X){
                    num++;
                }
                temp = temp/10;
                if(temp == 0){
                    if(temp == X){
                        num++;
                    }
                }
            }

        }
        System.out.println(num);

    }
}
