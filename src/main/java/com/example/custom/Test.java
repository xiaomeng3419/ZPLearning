package com.example.custom;

/**
 * Created by zhangpan on 2019/2/20.
 *
 * 相关博客研究地址：https://www.cnblogs.com/hglibin/p/10298650.html
 */
public class Test {

    public static void main(String[] args) {
        System.out.print(B.c);
    }
}

class A {
    public static String c = "C";
    static {
        System.out.print("A");
    }
}

class B extends A{
    static {
        System.out.print("B");
    }
}


