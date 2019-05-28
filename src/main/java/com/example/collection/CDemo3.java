package com.example.collection;

import com.example.collection.reflect.String;

/**
 * Created by zhangpan on 2019/3/17.
 */
public class CDemo3 {
    public static void main(String[] args) {
        Integer a = 124;
        Integer b =124;
        System.out.println(a==b);
        Integer c = 234;
        Integer d = 234;
        System.out.println(c==d);
        java.lang.String sq = "exeample";
        sq.concat("Test");
        System.out.println(sq);
    }
}
