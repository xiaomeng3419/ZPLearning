package com.example.custom;

import java.util.Scanner;

/**
 * Created by zhangpan on 2019/4/11.
 */
public class WZ2 {
    public static int getTime(int m ,int k,int n){
        if(n<=m){
            return k;
        }else {
            int s = n*k/m+n*k%m;
            return s;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//n个兽族
        int k = in.nextInt();//k个技能
        int m = in.nextInt();//m先知
        System.out.println(getTime(n,k,m));
    }
}
