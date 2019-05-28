package com.example.custom;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by zhangpan on 2019/4/11.
 */
public class YueSeFU {

    public static void fun(int humans,int key){

            if(humans == 1){
            System.out.println(humans);
            return;
        }
        if(humans == 1 && key == 1){
            System.out.println();
            System.out.println(1);
            return ;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<humans;i++){
            list.add(i+1);
        }
        if(key == 1){
            for (int i = 0;i<humans-1;i++){
                System.out.print(list.get(i)+ " " );
            }
            System.out.println();
            System.out.println(list.get(humans-1));
            return ;
        }

        int i =0;
        while (list.size()>0){
            i = i+key;
            i = i % (list.size()) - 1;
            if (i<0){
                System.out.println(list.get(list.size()-1));
                System.out.print(" ");
                list.remove(list.size()-1);
                i = 0;
            }else {
                System.out.print(list.get(i));
                System.out.print(" ");
                list.remove(i);
            }
            if(list.size() == 1){
                break;
            }
        }
        System.out.println(list.get(0));

    }

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int humans = in.nextInt();
        int key = in.nextInt();
        fun(humans,key);

    }
}
