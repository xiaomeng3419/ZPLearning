package com.example.interview.baidu;

import java.math.BigInteger;
import java.util.AbstractCollection;
import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月17日 19:40
 * @ModificationHistory:
 */
public class BaiduA {

    public static long getMinDis(long n ,long m ,BigInteger k){
        Long disMN = Long.MAX_VALUE;
        for (long i = 0; i <= n; i++) {
            for (long j = 0; j <= m&&m-j<disMN-(n-i); j++) {
                BigInteger temp = BigInteger.valueOf(i).multiply(BigInteger.valueOf(j));
                if (k.compareTo(temp)>=0){
                    Long a = n-i;
                    Long b = m-j;
                    Long disMNTemp = a+b;
                    disMN = disMN>=disMNTemp?disMNTemp:disMN;

                }else {
                    break;
                }
            }
        }
        return disMN;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(" ");
        long n = Integer.valueOf(arr[0]);
        long m = Integer.valueOf(arr[1]);
        BigInteger k = new BigInteger(arr[2]);
        System.out.println(getMinDis(n, m, k));
    }
}
