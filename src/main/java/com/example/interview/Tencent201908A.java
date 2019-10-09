package com.example.interview;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年08月17日 20:15
 * @ModificationHistory:
 */
public class Tencent201908A {
    static  Stack<Integer> si = new Stack<>();
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String word = sc.nextLine();
        char[] chs = word.toCharArray();
        boolean var1 = false;
        boolean var2 = false;
        StringBuffer sb = new StringBuffer();
        Stack<StringBuffer> ssb = new Stack<>();
        for (int i = 0; i < chs.length;) {
            if(chs[i]!='['&&chs[i]!=']'&&chs[i]!='|'){
                if(!var1&&!var2){
                    System.out.print(chs);
                }
                i++;
            }else if(chs[i]=='['){
                parseRange(chs,i,sb);
            }
        }
        System.out.println();
    }
    public static int parseRange(char[] chs,int i,StringBuffer var){
        if(chs[i] == '['){
            for (int j = 0; j < Integer.valueOf(chs[i+1]) ; j++) {
              parseRange(chs,i+2,var);
        }
        }else if(chs[i] == ']'){
            System.out.print(var);
            return i;
        }else {
            var.append(chs[i]);
        }
        return 1;
    }
}
