package com.example.collection;

import java.lang.*;
import java.util.*;

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
        Set<String> ss = new HashSet<>();
        ss.add("11d");
        ss.add("11c");
        ss.add("11d");
        ss.add("11a");
        ss.add("11b");
        Iterator<String> iterator = ss.iterator();
        while (iterator.hasNext()){
            String te = iterator.next();
            if(te.equals("11a")){
                iterator.remove();
                continue;
            }
            System.out.println(te);
        }
        System.out.println(ss.size());
//        HashMap
    }
}
