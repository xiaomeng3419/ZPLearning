package com.example.Functional.demo;

/**
 * @FunctionInterface ,作用是更好的给编译器检查
 * Created by zhangpan on 2018/11/22.
 */
@FunctionalInterface
public interface GofFunction<T1,T2> {
    public void execute(T1 t1,T2 t2);
}