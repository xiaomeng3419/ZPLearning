package com.example.zpproxy;

import java.lang.reflect.Method;
import java.util.Random;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class DynamicProxy implements MethodInterceptor {
	Object targetObject;


	//动态生成一个新的类，使用父类的无参构造方法创建一个指定了特定回调的代理实例
	public Object getProxyObject(Object object) {
		this.targetObject = object;
		 //增强器，动态代码生成器
		Enhancer enhancer = new Enhancer();		
		//回调方法.
		enhancer.setCallback(this);
		//设置生成类的父类类型
		enhancer.setSuperclass(targetObject.getClass());
		  //动态生成字节码并返回代理对象
        return enhancer.create();
	}

	   // 拦截方法

	@Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 被织入的横切内容，开始时间 before
        long start = System.currentTimeMillis();
        lazy();

        // 调用方法
        System.out.println("-----------------------1111");
        Object result = methodProxy.invoke(targetObject, args);
        System.out.println("-----------------------2222");
        // 被织入的横切内容，结束时间
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);
        
        return result;
    }
    // 模拟延时
    public void lazy() {
        try {
            int n = (int) new Random().nextInt(500);
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
