package com.example.interview.pdd;

import java.util.Scanner;

/**
 * Created by zhangpan on 2019/4/3.
 */
public class PDD4 {
    public static  int minDis(java.lang.String word1, java.lang.String word2){
        if(word1.equals("")&&word2.equals("")){
            return 0;

        }
        if(word1.equals("") && !word2.equals("")){
            return word2.length();
        }
        if(word2.equals("") && !word1.equals("")){
            return word1.length();
        }

        int[][] var = new int[word1.length()+1][word2.length()+1];
        for (int i = 0 ;i<= word1.length();i++){
            var[i][0] = i;
        }
        for (int i = 0 ;i<word1.length();i++){
            for (int j = 1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    var[i][j]=var[i-1][j-1];
                }else {
                    var[i][j] = Math.min(var[i-1][j]+1,Math.min(var[i][j-1]+1,var[i-1][j-1]+1));
                }
            }
        }
        for (int i = 0 ; i < var.length;i++){
            for (int j = 0 ; j<var[0].length;j++){
                System.out.print(var[i][j]);
            }
            System.out.println();
        }
        return  var[word1.length()][word2.length()];
    }


    public static void main(java.lang.String[] args) {
        Scanner sc=  new Scanner(System.in);
        java.lang.String word1;
        java.lang.String word2  ;
        word1 = sc.nextLine();
        word2 = sc.nextLine();
//        System.out.println(minDis(word1,word2));
    }



}
