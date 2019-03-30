package com.example.niuke;

import org.apache.tools.ant.taskdefs.condition.IsFalse;

import java.time.temporal.ValueRange;

/**
 * Created by zhangpan on 2019/2/21.
 */
public class niuke28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int count = 0;
        boolean flag = false;
        int result=0;
        int length = array.length;
        for (int i = 0;i<length;i++){
            int value = array[i];
            int temp = 0;
            for (int j = 0 ;j<length;j++){
                if (value == array[j]){
                    temp++;
                }
            }
            if(temp>=Math.ceil(length*1.0/2.0)){
                result = value;
                flag =true;
                break;
            }
        }
        if(flag){
            return result;
        }else {
            return 0;
        }

    }

    public static void main(String[] args) {
        niuke28 niuke28 = new niuke28();
        System.out.println(niuke28.MoreThanHalfNum_Solution(new int[]{1,2,3,2,4,2,5,2,3}));
    }
}
