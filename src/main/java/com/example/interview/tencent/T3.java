package com.example.interview.tencent;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by zhangpan on 2019/4/5.
 */
public class T3 {
    public static int getMin(int[] fire ,int[] price){
        if (fire.length == 0){
            return 0;
        }
        int currentFire = 0;
        int sum  = 0;
        if(fire.length == 1){
            return price[1];
        }
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2=o1;
            }
        });



        return 0;
//        for (int i=0;)



    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] fire = new int[n];
        int[] price = new int[n];
        for (int i = 0 ;i < n;i++){
            fire[i] = scanner.nextInt();
        }
        for (int i = 0 ;i < n;i++){
            price[i] = scanner.nextInt();
        }
    }
}
