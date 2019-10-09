package com.example.interview.WBank;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月19日 16:51
 * @ModificationHistory:
 */
public class WBankA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n  = scanner.nextInt();
        long s = 1;
        BigInteger mu = new BigInteger("1");

        for (int i = 1; i <= n; i++) {
            mu = mu.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println(mu);
        String result = "0";
        while (mu.compareTo(new BigInteger("0"))>=0){
            if(!mu.mod(new BigInteger("10")).toString().equals("0")){
                result = mu.mod(new BigInteger("10")).toString();
                break;
            }
            mu = mu.divide(new BigInteger("10"));
        }
        System.out.println(result);

    }


}
