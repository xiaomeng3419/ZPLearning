package com.example.interview;

import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年11月17日 16:21
 * @ModificationHistory:
 */



public class DemoA {
    public static void main(String[] args) {
//        boolean  dp = func(new Scanner(System.in).nextInt());
    }

   /* private static boolean func(int num) {
        boolean result = false;
        int maxDP = 1;

        int leftTemp = num;
        int rightTemp = num;
        while (num>0){
            if(num%10>0){
                maxDP = maxDP*10;
            }
            num = num/10;
        }
        int leftDP = maxDP;
        int rightDP = 10;
        while (leftDP>rightDP){
            if(leftTemp/leftDP == 0){
                if (rightTemp%rightDP==0){
                    leftDP = leftDP/10;
                    rightTemp = rightTemp/10;
                }else {
                    break;
                }
            }else {
                if (rightTemp%rightDP==leftTemp%10){
                    leftDP = leftDP/10;
                    rightTemp = rightTemp/10;
                    leftTemp = leftTemp%leftDP;
                }else {
                    break;
                }
            }

        }

    }
*/


}
