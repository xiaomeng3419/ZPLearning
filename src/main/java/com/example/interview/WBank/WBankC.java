package com.example.interview.WBank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月19日 17:27
 * @ModificationHistory:
 */
public class WBankC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer,List<Integer>> map = new HashMap<>();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int k = scanner.nextInt();
            int v = scanner.nextInt();

            if(map.containsKey(k)){
                List<Integer> s = map.get(k);
                s.add(v);
                map.put(k,s);
            }
            if(map.containsKey(v)){
                List<Integer> s = map.get(v);
                s.add(k);
                map.put(v,s);
            }
        }




    }
}
