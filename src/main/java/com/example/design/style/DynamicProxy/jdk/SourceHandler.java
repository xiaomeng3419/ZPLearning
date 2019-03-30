package com.example.design.style.DynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zhangpan on 2018/12/4.
 *
 * ����ͨ��sqlSession���mapper��������sqlSession��configuration�е�mapperRegistry�л�ȡMapperProxyFactory����
 * ��ͨ��MapperProxyFactory�����newInstance�����õ�MapperProxy�Ķ�̬����ʵ������
 ����ʹ�õ�mapper��ʵ��ͨ��MapperProxy��̬����������ʱ�����ɵ�һ���µĶ�����з�����ǿ�ģ�
 ����Ľӿڷ�������ͨ������2�����������ݿ�Ĳ������Լ����������ݵĴ���
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
