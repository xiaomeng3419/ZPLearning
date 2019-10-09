package com.example.interview.xiaomi;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月06日 19:25
 * @ModificationHistory:
 */
public class XiaomiA {
    static int solution(int[] prices, int budget) {
            int max = -1;
           Arrays.sort(prices);


            return max != -1?max+1:max;
    }

    static int fun(int[] prices,int budget,int index,int currentMax){
        if(budget%prices[index] == 0){
            return budget/prices[index];
        }
        if(index == 0){
            return -1;
        }
        for (int i = 1; i < currentMax+1; i++) {
            budget = budget - prices[index];
            int nextIndex = index -1;
            int nextCurrentMax = budget/prices[nextIndex];
            int result = fun(prices,budget,nextIndex,nextCurrentMax);
            if(result == -1){
                continue;
            }else {
                return result+currentMax-i;
            }
        }
        return  -1;


    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));

    }
}
