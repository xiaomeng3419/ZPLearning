package com.example.interview.tencent;

import java.util.Scanner;

/**
 * Created by zhangpan on 2019/5/29.
 */
public class ZJTDD3 {
   static int[] dh  = {0,1,0,-1};
   static int[] dw = {1,0,-1,0};
    public static boolean existWord(char[][] chs,String word){
        boolean[][] viewed = new  boolean[chs.length][chs[0].length];
        for (int i = 0 ; i < chs.length;i++){
            for (int j = 0 ; j <chs[0].length;j++){
                if (search(chs,word,i,j,0,viewed))
                    return true;
            }
        }
        return false;

    }

    public static boolean search(char[][] board,String word,int row ,int col,int index,boolean[][] viewed) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || viewed[row][col] || board[row][col] != word.charAt(index)) {

            return false;
        }
        if(++index == word.length())
            return true;
        viewed[row][col] = true;
        for (int i = 0 ;i <4;i++){
            if(search(board,word,row+dh[i],col+dw[i],index,viewed)){
                return true;
            }
        }
        viewed[row][col] = false;
        return false;

    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n, q;
        m = sc.nextInt();
        n = sc.nextInt();
        q = sc.nextInt();
        char[][] chs = new char[n][m];

        for (int i = 0; i < n; i++) {
            chs[i] = sc.nextLine().toCharArray();
        }
        for (int i = 0; i < q; i++) {
            String s = new String();
            s = sc.nextLine();
            if (new ZJTDD3().existWord(chs, s)) {
                System.out.println("Case " + i + ": Has");
            } else {
                System.out.println("Case " + i + ": Not Has");
            }
        }
    }

    public static boolean result =false;
    public static boolean  exist(char[][] board,String word){
        if(word.length() == 0){
            return true;
        }
        if(board.length == 0 || board[0].length == 0){
            return false;
        }
        for (int i = 0 ; i <board.length;i++){
            for (int j = 0 ; j <board[0].length;j++){
                char now = board[i][j];
                char first = word.charAt(0);
                if(now != first){
                    continue;
                }else {
                    begin(board,word,i,j);
                }
            }
        }
        return result;
    }

    private static   void begin(char[][] board, String word, int i, int j) {
        if(result == true) {
            return;
        }
        char now = board[i][j];
        char first = word.charAt(0);
        if(now != first){
            return;
        }
        if(word.length() == 1){
            result = true;
            return;
        }
        String newWord = word.substring(1);
        board[i][j] = '*';
        if (i>0){
            begin(board,newWord,i-1,j);
        }
        if(i<board.length-1){
            begin(board,newWord,i+1,j);
        }
        if (j>0){
            begin(board,newWord,i,j-1);
        }
        if (j<board[0].length-1){
           begin(board,word,i,j+1);
        }
        board[i][j] = now;
    }

}
