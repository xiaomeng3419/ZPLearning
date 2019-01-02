package com.example.niuke;

/**
 * Created by zhangpan on 2018/11/25.
 */
public class niuke1 {

    public class Solution {
        public boolean Find(int target, int [][] array) {
            int row = array.length;
            int col = array[0].length;

            if (row == 0 || col == 0)
                return false;
            if (target < array[0][0] || target > array[row - 1][col - 1])
                return false;
            int i = 0;
            int j = col - 1 ;
            boolean flag = false;
            while (i<row&&j>=0){
                if(target == array[i][j]){
                    return  true;

                }
                if(target < array[i][j]){
                    j--;
                    continue;
                }
                if (target>array[i][j]){
                    i++;
                    continue;
                }
            }
            return  false;
        }
    }

    public static void main(String[] args) throws Exception {
//        int
    }
}
