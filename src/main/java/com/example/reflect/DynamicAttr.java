package com.example.reflect;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import sun.plugin.dom.exception.WrongDocumentException;

import java.lang.reflect.Field;

/**
 * java的反射包基本是给Class
 * Created by zhangpan on 2018/11/21.
 * 学习地址：https://www.sczyh30.com/posts/Java/java-reflection-1/
 * 此外和反射相关联的就是：invoke方法
 */
public class DynamicAttr {

   /** public static  <T>  Object getReflection(String className,String rspXml) throws ClassNotFoundException,
            WrongDocumentException, IllegalArgumentException, IllegalAccessException,DocumentException,
            InstantiationException, SecurityException, NoSuchFieldException{
        //class.forName作用是jvm动态调用静态代码段创建一个类，返回的是一个类对象，
        //和new 实例的却别就是
        Object o = Class.forName(className).newInstance();
        Class clz = Class.forName(className).newInstance().getClass();
        Document doc = null;
        doc =  DocumentHelper.parseText(rspXml);




    }
    首先先了解下modifiers 访问控制修饰符
    **/
//    Integer.TYPE

    /**
     * @see com.example.utils.ListToMap
     * @param args
     */
   public static void main(String[] args)throws Exception {
       String p = new String();
       Class<?> classType = p.getClass();

       Field field = classType.getDeclaredField("name");

//       Field.setAccessible(true); // 抑制Java对修饰符的检查
   }



}
