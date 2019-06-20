package com.example.niuke.common;

/**
 * Created by zhangpan on 2019/4/1.
 */
public class LongestSingleSubstring
{
    public static void main(String[] args)
    {
        System.out.println(findLongestSubstringLength("arabcacfr")); //4
        System.out.println(findLongestSubstringLength("bbb")); //1
        System.out.println(findLongestSubstringLength("")); //0
    }

    private static int findLongestSubstringLength(String string)
    {
        if (string == null || string.equals("")) return 0;
        int maxLength = 0;
        int curLength = 0;
        int[] positions = new int[26];
        for (int i = 0; i < positions.length; i++)
        {
            positions[i] = -1; //初始化为-1，负数表示没出现过
        }
        for (int i = 0; i < string.length(); i++)
        {
            int curChar = string.charAt(i) - 'a';
            int prePosition = positions[curChar];
            //当前字符与它上次出现位置之间的距离
            int distance = i - prePosition;
            //当前字符第一次出现，或者前一个非重复子字符串中没有包含当前字符
            if (prePosition < 0 || distance > curLength)
            {
                curLength++;
            } else
            {
                //更新最长非重复子字符串的长度
                if (curLength > maxLength)
                {
                    maxLength = curLength;
                }
                curLength = distance;
            }
            positions[curChar] = i; //更新字符出现的位置
        }
        if (curLength > maxLength)
        {
            maxLength = curLength;
        }
        return maxLength;
    }
}