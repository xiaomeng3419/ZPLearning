package com.example.DynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import com.example.DynamicProxy.jdk.Source;
/**
 * Created by zhangpan on 2018/12/4.
 */
public class SourceHandler implements InvocationHandler {

    private  Object source;

    public SourceHandler(Object source) {
        this.source = source;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(source, args);
        after();
        return object;
    }
    public void before(){
        System.out.println("before proxy!");
    } public void after(){
        System.out.println("after proxy!");
    }
}
