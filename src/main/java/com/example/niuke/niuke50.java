package com.example.niuke;

/**
 * Created by zhangpan on 2019/3/23.
 *
 */
public class niuke50 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
              duplication[0]=-1;
            if(numbers==null||numbers.length==0||numbers.length == 1){
                return false;
            }
            boolean flag = false;
            for (int i = 0 ;i < numbers.length;i++){
                for (int j = i+1;j<numbers.length;j++){
                    if(numbers[i] == numbers[j]){
                        flag = true;
                        duplication[0] = numbers[i];
                        return flag;
                    }
                }
            }
        return false;

    }

    public static void main(String[] args) {
        int[] result = new int[2];
        System.out.println(new niuke50().duplicate(new int[]{1,3,2,4,5,6,6},7,result));
        System.out.println(new niuke50().duplicate(null,7,result));
        System.out.println(result[0]);
    }
    }
