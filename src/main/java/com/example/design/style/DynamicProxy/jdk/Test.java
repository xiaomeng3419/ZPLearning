package com.example.design.style.DynamicProxy.jdk;

import java.lang.reflect.Proxy;

/**
 * Created by zhangpan on 2018/12/4.
 *
 *jdk������Ǵ�ĳ���ӿڵķ����ϼ��뼸��֪ͨ�ɣ�����spring��ǰ��֪ͨ������֪ͨ�ͻ���֪ͨ
 *�ӿ�Ҳ���Ե��������������ǿ��ת��Ϊ����
 * jdk�����Ǵ�����
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
