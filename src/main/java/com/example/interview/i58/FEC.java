package com.example.interview.i58;

import java.util.Arrays;
import java.util.*;
import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年10月13日 20:41
 * @ModificationHistory:
 */
public class FEC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            list.add(temp);
        }
        list.sort(Integer::compareTo);
        int curLen = n-1;
        while ((m--)>0) {
            int index = -1;
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i) != list.get(0)){
                     index = i;
                     break;
                }
            }
            if(index == -1){
                break;
            }
            list.set(0, list.get(0) + list.get(index));
            list.remove(index);
            list.sort(Integer::compareTo);

        }
        list.sort(Integer::compareTo);
        System.out.println(list.get(0));
    }


}
