package com.example.interview.bytedance;

import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年08月25日 19:17
 * @ModificationHistory:
 */
public class ByteDanceB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println((int)Math.pow(2,n/2)-n/2);
    }
}
