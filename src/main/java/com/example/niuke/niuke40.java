package com.example.niuke;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * Created by zhangpan on 2019/3/20.
 */
public class niuke40 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        num1[0]= num2[0] = -1;
        Map<Integer ,Integer> map = new HashMap<>();
        for ( int num : array) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        for (Map.Entry<Integer,Integer> var : map.entrySet()) {
           if(var.getValue() == 1){
               if(num1[0]==-1){
                   num1[0] = var.getKey();
               }else {
                   num2[0] = var.getKey();
               }
           }
        }


    }

    public static void main(String[] args) {




    }
}
