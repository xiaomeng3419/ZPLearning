package com.example.interview.i58;

import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年10月13日 20:38
 * @ModificationHistory:
 */
public class FEB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int var1 = 1;
        int var2 = 2;
        if(n == 1){
            System.out.println(1);
        }else if (n == 2){
            System.out.println(2);
        }else {

            for (int i = 3; i <=  n ; i++) {
                    int temp = var2;
                    var2 = var2+var1;
                    var1 = temp;
            }
            System.out.println(var2);
        }

    }
}
