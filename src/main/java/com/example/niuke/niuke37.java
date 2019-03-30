package com.example.niuke;

/**
 * Created by zhangpan on 2019/3/13.
 */
public class niuke37 {
    public int GetNumberOfK(int [] array , int k) {
            int count=0;

            for (int x:array) {
                if (x == k){
                    count++;

                }
            }
            return count;
    }

    public static void main(String[] args) {
        System.out.println(new niuke37().GetNumberOfK(new int[]{1,2,3,4,5,2,2},2));
    }

}
