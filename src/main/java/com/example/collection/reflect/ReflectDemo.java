package com.example.collection.reflect;

import java.lang.*;
import java.lang.String;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangpan on 2019/4/1.
 * 通过反射调用私有的main方法
 * 可以用反射实现
 */
public class ReflectDemo {

    public static void main(java.lang.String[] args) throws Exception{
        Class<?> cls = com.example.collection.reflect.String.class;
//        Class.forName()

        Method mainMethod= cls.getDeclaredMethod("main", String[].class);
        mainMethod.setAccessible(true);
        java.lang.String[] args1 = new java.lang.String[] {"20190212"};
        mainMethod.invoke(null, (Object) args );
//        ReentrantLock
    }
}
