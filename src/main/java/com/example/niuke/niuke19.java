package com.example.niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangpan on 2019/2/18.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class niuke19 {
    public static void main(String[] args) {
        new niuke19().printMatrix2(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,29,20},{21,22,23,24,25}});
    }
    void printself(int[][] matrixflag){
        for (int i = 0 ;i<matrixflag.length;i++){
            for (int j = 0 ;j < matrixflag[0].length;j++){
                System.out.print(matrixflag[i][j]);
            }
            System.out.println();
        }
    }


    public ArrayList<Integer> printMatrix2(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length==0){
            return list;
        }
        int row = matrix.length;
        int col  = matrix[0].length;
        int [][] matrixflag = new int[row+2][col+2];
        for (int i = 0;i<col+2;i++){
            //横向填，
            matrixflag[0][i]=1;
            matrixflag[row+1][i]=1;
        }
        for (int i = 0;i<row+2;i++){
            //横向填，
            matrixflag[i][0]=1;
            matrixflag[i][col+1]=1;
        }

        int drect = 1;//右向1，下向2，左向3，上向4
        int i=0,j=0;
        while (true){
            if(matrixflag[i+1][j+1]==0){
                System.out.print(matrix[i][j]);
                list.add(matrix[i][j]);
                matrixflag[i+1][j+1]=1;
                if(drect==1){
                    j++;
                }
                if(drect == 2){
                    i++;
                }
                if (drect==3){
                    j--;
                }
                if(drect == 4){
                    i--;
                }
            }else {
                if (drect==1){
                    if(matrixflag[i+2][j]==1){
                        printself(matrixflag);
                        break;
                    }
                    j=j-1;
                    drect=2;
                    i+=1;
                    continue;
                }
                if (drect==2){
                    if(matrixflag[i][j]==1){
                        break;
                    }
                    i=i-1;
                    drect=3;
                    j-=1;
                    continue;
                }
                if (drect==3){
                    if(matrixflag[i][j+2]==1){
                        break;
                    }
                    drect=4;
                    j=j+1;
                    i-=1;
                    continue;
                }
                if (drect==4){
                    if(matrixflag[i+2][j+2]==1){
                        break;
                    }
                    i=i+1;
                    drect=1;
                    j+=1;
                    continue;
                }
            }

        }
        return list;
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length==0){
            return list;
        }
        int row = matrix.length;
        int col  = matrix[0].length;
        int [][] matrixflag = new int[row][col];
        int left= 0;
        int top= 0;
        int right= col-1;
        int bot= row-1;
        int i=0,j=0;
        int drect = 1;//右向1，下向2，左向3，上向4
        while (true){
           if(matrixflag[i][j]==0){
               System.out.print(matrix[i][j]);
               matrixflag[i][j]=1;
               if (i<bot&&j<right){
                    if(drect==1){
                        j++;
                    }
                    if(drect == 2){
                        i++;
                    }
                    if (drect==3){
                        j--;
                    }
                    if(drect == 4){
                        i--;
                    }
               }
               if(j==right&&drect==1){
                   drect = 2;
                   top+=1;
                   i++;
               }

           }else {
                return list;
           }
        }
//        return list;
    }
}
