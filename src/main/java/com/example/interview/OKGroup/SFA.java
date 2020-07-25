package com.example.interview.OKGroup;

import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年10月24日 16:52
 * @ModificationHistory:
 */
public class SFA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int[] flag = new int[str.length()];

        char[] chs = str.toCharArray();

        for (int i = 1; i < chs.length; i++) {
            if(chs[i]==chs[i-1]){
                flag[i] = flag[i-1] = -1;
            }else {
                if (flag[i-1] == 0 || flag[i-1] == 1){
                    flag[i] = 1;
                }
            }
        }
        int nums = 0;
        for (int i = 0; i < chs.length; i++) {
            if(flag[i]==0){
                nums++;
            }
        }
        System.out.println(nums);

    }


}
