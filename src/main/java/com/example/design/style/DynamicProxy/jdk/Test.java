package com.example.design.style.DynamicProxy.jdk;

import java.lang.reflect.Proxy;

/**
 * Created by zhangpan on 2018/12/4.
 *
 *jdk代理就是从某个接口的方法上加入几种通知吧：例如spring的前置通知，后置通知和环绕通知
 *接口也可以当做对象，子类可以强制转化为父类
 * jdk代理是代理类
 */
public class Test {


    public static void main(String[] args) {

        Sourceable source = new Source();
        System.out.println(String.valueOf(source.getClass().getInterfaces()));
        System.out.println(String.valueOf(source.getClass().getMethods()[0].getName()));
        Sourceable obj = (Sourceable)
                Proxy.newProxyInstance(source.getClass().getClassLoader(),
                        source.getClass().getInterfaces(), new SourceHandler(source));
        obj.method();

    }
}
