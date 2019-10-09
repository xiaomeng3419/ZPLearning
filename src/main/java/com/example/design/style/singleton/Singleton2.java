package com.example.design.style.singleton;

import com.example.collection.CDemo7;

/**
 * Created by zhangpan on 2019/7/25.
 */
public class Singleton2 {

    private static class LazyHolder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }
    public static Singleton2 getInstance() {
        return Singleton2.LazyHolder.INSTANCE;
    }
}
