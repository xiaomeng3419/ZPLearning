package com.example.DynamicProxy.cglib;

/**
 * Created by zhangpan on 2018/12/4.
 */
import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
public class CglibProxy implements MethodInterceptor {
    private Object target;

    public Object createProxy(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        before();
        Object object = method.invoke(target, args);
        after();
        return object;
    }

    public void before() {
        System.out.println("before proxy!");
    }

    public void after() {
        System.out.println("after proxy!");
    }
}