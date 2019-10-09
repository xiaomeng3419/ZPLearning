package com.example.leetcode;

import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月21日 23:59
 * @ModificationHistory: dp[i][j] = dp[i][j - 1] + (T[i - 1] == S[j - 1] ? dp[i - 1][j - 1] : 0)
 */
public class Leetcode115 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String k = scanner.nextLine();
        System.out.println(numDistinct(s,k));

    }
    public static int numDistinct(String s, String t) {
    if(s.isEmpty())
            return 0;
    int[][] flag = new int[t.length()+1][s.length()+1];
    int sn = s.length()+1;
    int tn = t.length()+1;
    for (int i = 0; i < sn ; i++) {
            flag[0][i]=1;
    }
        for (int i = 1; i < tn; i++) {
            for (int j = 1; j < sn; j++) {
                if(t.charAt(i-1) == s.charAt(j-1)){
                    flag[i][j] = flag[i-1][j-1]+flag[i][j-1];
                }else {
                    flag[i][j] = flag[i][j - 1] +0;
                }
//                System.out.print(flag[i][j] + " ");
            }
//            System.out.println();
        }
        return flag[tn-1][sn-1];

    }
}
