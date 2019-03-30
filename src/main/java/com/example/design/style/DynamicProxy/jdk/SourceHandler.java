package com.example.design.style.DynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zhangpan on 2018/12/4.
 *
 * 我们通过sqlSession获得mapper方法，而sqlSession从configuration中的mapperRegistry中获取MapperProxyFactory对象，
 * 在通过MapperProxyFactory对象的newInstance方法得到MapperProxy的动态代理实例对象。
 我们使用的mapper其实是通过MapperProxy动态代理，在运行时候生成的一个新的对象进行方法增强的，
 里面的接口方法都会通过下面2个语句进行数据库的操作，以及后续对数据的处理
 final MapperMethod mapperMethod = cachedMapperMethod(method);
 return mapperMethod.execute(sqlSession, args);
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
