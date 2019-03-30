package com.example.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangpan on 2019/3/15.
 */
public class Tencent1 {
    public static Set<String> getCount(String str){
        Set<String> set = new HashSet<>();
        if (str.length()==0){
            return set;
        }
        int len  = str.length();
        Map<String,Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        int num =0;
        for (int i = 0;i<len ;i++){
            if(map.containsKey(String.valueOf(chars[i]))){
                map.put(String.valueOf(chars[i]),map.get(String.valueOf(chars[i]))+1);
            }else {
                map.put(String.valueOf(chars[i]),1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet() ) {
            if(entry.getValue()>num){
                set.clear();
                set.add(entry.getKey());
                num=entry.getValue();
            }else if(entry.getValue()==num){
                set.add(entry.getKey());
            }

        }
        System.out.println(num);
        return set;
    }
    public static void main(String[] args) {
        String str="zadfadfasdsjdkhjd";
        String str1="aaabbb";
        String str2="";
        System.out.println(getCount(str).toString());
        System.out.println(getCount(str1).toString());
        System.out.println(getCount(str2).toString());
    }
}
