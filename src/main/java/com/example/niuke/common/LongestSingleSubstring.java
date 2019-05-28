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
            positions[i] = -1; //��ʼ��Ϊ-1��������ʾû���ֹ�
        }
        for (int i = 0; i < string.length(); i++)
        {
            int curChar = string.charAt(i) - 'a';
            int prePosition = positions[curChar];
            //��ǰ�ַ������ϴγ���λ��֮��ľ���
            int distance = i - prePosition;
            //��ǰ�ַ���һ�γ��֣�����ǰһ�����ظ����ַ�����û�а�����ǰ�ַ�
            if (prePosition < 0 || distance > curLength)
            {
                curLength++;
            } else
            {
                //��������ظ����ַ����ĳ���
                if (curLength > maxLength)
                {
                    maxLength = curLength;
                }
                curLength = distance;
            }
            positions[curChar] = i; //�����ַ����ֵ�λ��
        }
        if (curLength > maxLength)
        {
            maxLength = curLength;
        }
        return maxLength;
    }
}