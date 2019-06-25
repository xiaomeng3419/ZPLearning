package com.example.collection;

import java.lang.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by zhangpan on 2019/4/1.
 */
public class CDemo6 {
    private  final int num ;
    private final  static  int fs =8;
    volatile int vt = 0;
    final   void fun(){
        System.out.println(fs);

    }
    public  CDemo6(int num){
        super();
        this.num = num;
        vt=num;
    }


    public static void main(java.lang.String[] args) {
//        CDemo6 cDemo6 = new CDemo6(12);
//        System.out.println(cDemo6.num);
        System.out.println("中文乱码");
//        HashMap
    }
}
