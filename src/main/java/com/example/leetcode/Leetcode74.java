package com.example.leetcode;

/**
 * Created by zhangpan on 2019/4/3.
 */
public class Leetcode74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0){
            return false;
        }
        int row=matrix.length;
        int column=matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=column-1;j>=0;j--){
                if(matrix[i][j]==target){
                    return true;
                }else if(matrix[i][j]>target){
                    continue;
                }else{
                    break;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
