package com.example.zpwlx.consumer;

import com.example.zpwlx.core.ProxyHandler;

import java.lang.reflect.Proxy;

/**
 * Created by zhangpan on 2019/7/20.
 * 封装一个代理类处理器
 返回service的代理类对象
 */
public class RpcConsumer {
    public static <T> T getService(Class<T> clazz,String ip,int port){
        ProxyHandler proxyHandler  = new ProxyHandler(ip,port);
        return (T) Proxy.newProxyInstance(RpcConsumer.class.getClassLoader(),new Class<?>[]{clazz},proxyHandler);
    }
}
