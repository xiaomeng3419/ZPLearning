package com.example.DynamicProxy.cglib;

/**
 * Created by zhangpan on 2018/12/4.
 * cglib代理的是代理的接口
 */
public class Test {

    public static void main(String[] args) {
        Source source = new Source();
        Source cglibProxy = (Source) new CglibProxy().createProxy(source);
        cglibProxy.method();
    }
}
