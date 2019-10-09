package com.example.interview.kuaishou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月16日 22:13
 * @ModificationHistory:
 */
public class KSC {
    private static int S1 = 0;
    private static int S2 = 0;

    public static int calc (int[] item){
        for (int i = item.length-1; i >=0; i--) {
            if(S1>=S2){
                S2+=item[i];
            }else {
                S1+=item[i];
            }
        }
        return S1>=S2?S1-S2:S2-S1;

    }


    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int n  = scanner.nextInt();
        int[] item = new int[n];
        for (int i = 0; i < n; i++) {
             item[i] = scanner.nextInt();
        }
        Arrays.sort(item);
        System.out.println(calc(item));
    }
}
