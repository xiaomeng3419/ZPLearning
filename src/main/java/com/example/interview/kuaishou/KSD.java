package com.example.interview.kuaishou;

import java.util.*;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月16日 22:20
 * @ModificationHistory:
 */
public class KSD {

    public static int maxLen = 0;

    public static int maxValue = 0;

    public static Set<Integer> dis = new HashSet<>();

    public static void findMaxLen(List<Integer> list){
        maxValue = list.get(list.size()-1);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1 ; j < list.size(); j++) {
                dis.add(list.get(j)-list.get(i));
            }
        }

        for (Integer disItem:dis) {
            for (int j = 0; j < list.size(); j++) {
                int temp = 1;
                int pos = list.get(j);
                while (true){
                    if (list.contains(pos+=disItem)){
                        temp++;
                    }else {
                        break;
                    }
                }
                maxLen=maxLen>temp?maxLen:temp;
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        final int[] item = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            list.add(scanner.nextInt());

        }
        list.sort(Integer::compareTo);
        findMaxLen(list);
        System.out.println(maxLen);
    }
}
