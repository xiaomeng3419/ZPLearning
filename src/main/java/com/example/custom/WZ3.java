package com.example.custom;

import java.util.Scanner;

/**
 * Created by zhangpan on 2019/4/11.
 */
public class WZ3 {
    public static int  jump(int n){
        int count = 0;
        while (n!=1){
            if(n%2 == 0){
                n = n/2;
            }else {
                n = 3*n +1;
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner( System.in);
        int T = in.nextInt();
        int[] arr = new int[T];
        for (int i = 0 ;i<T;i++){
            arr[i] = in.nextInt();
        }

        for (int i = 0 ;i<T;i++){
            System.out.println(jump(arr[i]));
        }

    }
}
