package com.example.leetcode;
import com.google.common.collect.Lists;

import java.util.*;

/**
 * Created by zhangpan on 2019/8/1.
 */
public class Leetcode120 {

    public  synchronized void complieSync1(){
        System.out.println("check compile code ...");
    }

    public  void complieSync2(){
        synchronized(this){

        }

    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int [][] dp=new int [n+1][n+1];//防止下标越界
        for(int i=n-1;i>=0;i--)//思路很简单，自底向上
        {
            for(int j=0;j<triangle.get(i).size();j++)
            {
                System.out.println(Math.min(dp[i+1][j],dp[i+1][j+1]));
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);//递推公式还是很明显的，就是list里的元素
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        List<List<Integer>> list =Lists.newArrayList();

        List<Integer> item1 = Lists.newArrayList();
        item1.add(2);
        list.add(item1);
        List<Integer> item2 = Lists.newArrayList();
        item2.add(3);
        item2.add(4);
        list.add(item2);
        List<Integer> item3 = Lists.newArrayList();
        item3.add(6);
        item3.add(5);
        item3.add(7);
        list.add(item3);
        List<Integer> item4 = Lists.newArrayList();
        item4.add(4);
        item4.add(1);
        item4.add(8);
        item4.add(3);
        System.out.println(minimumTotal(list));

    }

}
