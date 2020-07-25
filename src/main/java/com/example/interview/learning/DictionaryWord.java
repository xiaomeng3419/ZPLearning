package com.example.interview.learning;

import java.util.*;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年10月16日 22:58
 * @ModificationHistory: 判断字符串是否由字典组成 . *
 * https://www.cnblogs.com/yjxyy/p/11080217.html
 */
public class DictionaryWord {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("my");
        list.add("is");
        list.add("jack" );
        list.add("name");
        String str = "myisisjack";
        System.out.println(workBreak(str,list));
    }

    public static boolean workBreak(String s, List<String> wordList){
        if(s == null|| wordList.isEmpty()){
            return false;
        }

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <=s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]&& wordList.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
