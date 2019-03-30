package com.example.niuke;

import java.util.ArrayList;

/**
 * Created by zhangpan on 2019/3/21.
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class niuke42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int temp=0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i<array.length;i++){
            for (int j = i+1;j<array.length;j++){
                if(array[i]+array[j]== sum){
                    if(temp == 0||temp>array[i]*array[j]){
//                        if(array[j]==11){
//
//                        }
                        list.clear();
                        list.add(array[i]);
                        list.add(array[j]);
                        temp= array[i]*array[j];
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new niuke42().FindNumbersWithSum(new int[]{1,2,3,4,5,6,7,8,9},10));
        System.out.println(new niuke42().FindNumbersWithSum(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20},21));
    }
}
