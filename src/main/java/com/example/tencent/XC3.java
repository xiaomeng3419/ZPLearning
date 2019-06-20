package com.example.tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zhangpan on 2019/4/8.
 */
public class XC3 {
    static Map<String,Integer> map = new HashMap<>();
    static Map<String,Integer> map1 = new HashMap<>();
    public static void fun(String str){
        int flag= 1;
        if(map1.containsKey(str)){
            map1.put(str,map.get(str)+1);

        }else {
            map1.put(str,1);
        }
        flag = map1.get(str);
        String[] var = str.split("/");
        int[] num  = new int[var.length];
        for (int i = 0;i<var.length;i++){
            if(map.containsKey(var[i])){
                map.put(var[i],map.get(var[i])+1);
            }else {
                map.put(var[i],1);
            }
           if(i!=0&&i!=var.length-1){
               System.out.print(flag);
           }
            System.out.print(1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] strings = input.split(" ");
        int n = Integer.parseInt(strings[0]);
//        String s = sc.nextLine();
        String[] strs = new String[n];

        for (int i = 0;i< n;i++){

            strs[i] = strings[i+1].substring(1);
            fun(strs[i]);
            if(i!= strings.length-2){
                System.out.println(" ");
            }
        }
    }
}
