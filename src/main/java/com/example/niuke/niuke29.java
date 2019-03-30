package com.example.niuke;

import com.sun.org.apache.bcel.internal.generic.GOTO;

import java.util.ArrayList;

/**
 * Created by zhangpan on 2019/2/21.
 */
public class niuke29 {
    public static void main(String[] args) {
        niuke29 niuke29 = new niuke29();
        System.out.println(niuke29.GetLeastNumbers_Solution(new int[]{1,2,3,2,4,2,5,2,3},2).toString());
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>(k);
        if(input.length==0||k==0||k>input.length){
            return list;
        }
        for(int i = 0 ;i<k;i++){
            int temp = input[i];
            for (int j=i+1;j<input.length;j++){
                if(input[i]>input[j]){
                     temp = input[i];
                     input[i] = input[j];
                     input[j] = temp;
                }
            }
        }
        for (int i = 0 ;i<k;i++){
            list.add(input[i]);
        }
return list;
    }
}
