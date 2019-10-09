package com.example.design.style.singleton;

/**
 * Created by zhangpan on 2019/7/25.
 */
public class Singleton1 {
    public static Singleton1 singleton1 = new Singleton1();

    public static Singleton1 getSingleton1 (){
        return singleton1;

    }
}
