package com.example.design.style.singleton;

import java.util.Objects;

/**
 * Created by zhangpan on 2019/3/13.
 */
public class Singleton {
    private volatile static  Singleton singleton;
    private Singleton(){}

    public static Singleton getSingleton(){
        if (singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton    ;
    }
}
