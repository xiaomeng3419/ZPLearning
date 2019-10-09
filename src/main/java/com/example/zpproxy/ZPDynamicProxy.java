package com.example.zpproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * jdK动态代理
 */
public class ZPDynamicProxy implements InvocationHandler{
	
	Object targetObject;
	
	
	public Object getProxyObject(Object object) {
		this.targetObject = object;
		System.out.println(targetObject.getClass().getClassLoader().toString());
		System.out.println(targetObject.getClass().getInterfaces().toString());
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), 
				targetObject.getClass().getInterfaces(),
				this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		long start = System.currentTimeMillis();
		lazy();
		Object result  = method.invoke(targetObject, args);
		Long span= System.currentTimeMillis()-start;
		System.out.println("共用时："+span);
		return result;
	}
	
	public void lazy() {
		try {
			  int n=(int)new Random().nextInt(500);
			  Thread.sleep(n);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
