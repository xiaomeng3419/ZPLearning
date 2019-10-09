package com.example.interview.t60;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年08月31日 16:37
 * @ModificationHistory:
 */
public class T60A {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chs = line.toCharArray();
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            if(map.containsKey(chs[i]+"")){
                map.put(chs[i]+"",map.get(chs[i]+"")+1);
            }else {
                map.put(chs[i]+"",1);
            }
        }
        int max = 0;
        for (String entry :map.keySet()){
            max = max>map.get(entry)?max:map.get(entry);
        }
        System.out.println(max);
    }
}
