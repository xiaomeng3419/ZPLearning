package com.example.leetcode;

/**
 * 最长回文子串的话就是动态规划里面的最长公共子序列
 * Created by zhangpan on 2019/3/21.
 */
public class Leetcode516 {
    public int longestPalindromeSubseq(String s) {
        if(s.length()==0||s.length() == 1){
            return s.length();
        }
        char[] var1 = s.toCharArray();
        char[] var2 = new char[var1.length];
        int len = s.length();
        int j = len-1;
       for (int i = 0 ;i<len;i++,j--){
           var2[i] = var1[j];
       }

       int[][]  flag = new  int[len+1][len+1];
        return getMaxLen(var1,var2,flag);

}
    public int getMaxLen(char[] var1 ,char[] var2 , int[][] flag){
        int maxL = 0;
        for (int i = 0;i<var1.length;i++){
            for (int j = 0 ; j<var2.length;j++){
                if(var1[i] == var2[j]){
                    flag[i+1][j+1] = flag[i][j]+1;
                    maxL = maxL> flag[i+1][j+1]? maxL: flag[i+1][j+1];
                }else {
                    flag[i+1][j+1] = flag[i+1][j]>flag[i][j+1]? flag[i+1][j] : flag[i][j+1];

                }
            }
        }
        getMaxLStr(var1,var2,flag);
        return maxL;
    }

    public  String getMaxLStr (char[] var1 ,char[] var2,int[][] flag) {
        int row = flag.length;
        int col = flag[0].length;
        int i = row - 1;
        int j = col - 1;
        while (true) {
            int temp = flag[i][j];
            if (var1[i-1] == var2[j-1]) {
                System.out.print(var1[i-1] + "  ");
                i = i - 1;
                j = j - 1;
                if (flag[i][j] == 0) {
                    break;
                }
            } else {
                if (flag[i][j - 1] == temp) {
                    j = j - 1;
                } else {
                    i = i - 1;
                }

            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode516().longestPalindromeSubseq("bbbab"));
        System.out.println(new Leetcode516().longestPalindromeSubseq("cbbd"));
        System.out.println(new Leetcode516().longestPalindromeSubseq("abcdedbca"));
    }
}
