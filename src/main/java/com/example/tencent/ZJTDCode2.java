package com.example.tencent;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by zhangpan on 2019/5/29.
 * Case 0: Has
 Case 1: Has
 Case 2: Has
 Case 3: Not Has
 Case 4: Not Has
 */
public class ZJTDCode2 {
 /*   public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int m ,n,q;
         m = sc.nextInt();
         n = sc.nextInt();
         q = sc.nextInt();
         char[][] chs = new char[n][m];

         for(int i = 0 ; i < n;i++){
            chs[i] = sc.nextLine().toCharArray();
         }
        for (int i = 0 ; i < q ;i++){
             if(chs.length == 0){
                 System.out.println("Case "+i+": Not Has");
                 continue;
             }
            char[] s = new char[chs[0].length];
             s = sc.nextLine().toCharArray();
             for (int y = 0 ; y<chs[0].length;y++){
                 for (int x = 0 ; x<chs[0].length;x++){
                     if (chs[y][x] == s[0]){
                         if(search(chs,s,y,x)){
                             System.out.println("Case "+i+": Has");
                         }else {
                             System.out.println("Case "+i+": Not Has");
                         }
                     }
                 }
             }

        }


    }

    public static boolean search(char[][] chs ,char[] ch,int row,int col){
        int direct = 1;//1右2下3左4上
        char[][] flag = new char[chs.length][chs[0].length];
        flag[row][col] = 1;
        for (int i =0;i<ch.length;i++){

        }

    }*/
//    public HashSet<String> search(char[][] board,String[] words){
//
//    }
//
//
//}
//class  Trie {
//    private TrieNode root;
//    public Trie(){
//        root = new TrieNode();
//        root.val = ' ';
//
//    }
//
//}

//class TrieNode{
//    public char val;
//    public boolean isword;
//    public TireNode[] children = new TireNode[26];
//    public TireNode(){}
//    public TireNode(char c){
//        isword = false;
//        this.val = c;
//    }
}
