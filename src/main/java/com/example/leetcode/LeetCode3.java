package com.example.leetcode;

import java.util.LinkedList;

/**
 * Created by zhangpan on 2019/4/1.
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int num=0;//记录最长子串长度
        int current=0;//记录当前子串长度
        char[] arr=s.toCharArray();
        LinkedList<Character> temp=new LinkedList<>();

        for (int i=0;i<arr.length ;i++ )
        {
            if (!temp.contains(arr[i]))
            {
                temp.add(arr[i]);
                current=temp.size();
                if (current>num)
                    num=current;
            }
            else//如果新增字符与原子串中字符有重复的，删除原子串中重复字符及在它之前的字符，与新增字符组成新的子串
            {
                temp.add(arr[i]);
                int first=temp.indexOf(arr[i]);

                for (int j=0;j<first ;j++ )
                    temp.remove();

                temp.remove();
            }
        }
        return num;
    }
    public static void main(String[] args) {
        System.out.println(new LeetCode3().lengthOfLongestSubstring("dafsdasdffgqerqw"));
    }
}
