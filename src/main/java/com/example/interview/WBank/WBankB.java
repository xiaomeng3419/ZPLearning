package com.example.interview.WBank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月19日 17:00
 * @ModificationHistory:
 */
public class WBankB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l =Long.valueOf(scanner.nextLine());
        long sl =1;
        for (long i = 1; i <= l; i++) {
            sl = sl*i;
        }
        System.out.println(sl%1000003);


    }
}
