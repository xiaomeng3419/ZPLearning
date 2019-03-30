package com.example.niuke;

/**
 * Created by zhangpan on 2019/3/21.
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class niuke43 {
    public String LeftRotateString(String str,int n) {
            if (str.length()==0){
                return str;
            }
        StringBuffer sb = new StringBuffer(str) ;
        int len = str.length()-1;
        for (int i = 0;i<n;i++){
            char c= sb.charAt(0);
            sb = sb.deleteCharAt(0);
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(new niuke43().LeftRotateString("abcdefg",2));
    }
}
