package com.example.leetcode;

import java.util.LinkedList;

/**
 * Created by zhangpan on 2019/4/1.
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int num=0;//��¼��Ӵ�����
        int current=0;//��¼��ǰ�Ӵ�����
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
            else//��������ַ���ԭ�Ӵ����ַ����ظ��ģ�ɾ��ԭ�Ӵ����ظ��ַ�������֮ǰ���ַ����������ַ�����µ��Ӵ�
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
