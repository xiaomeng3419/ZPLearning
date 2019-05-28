package com.example.collection;

/**
 * 类加载的顺序 1、父类静态代码块
 静态方法中局部变量 m=1
 null
 父类静态方法
 * Created by zhangpan on 2019/4/14.
 */
public class CDemo9{
    int m = 10;
    static{
        System.out.println("父类静态代码块");
        fu();
    }
    {
        System.out.println("代码块中的父类实例变量 m="+m);
        System.out.println("父类代码块");
    }
    CDemo9(){
        System.out.println("父类构造器");
    }
    static void fu(){
        int m = 1;
        System.out.println("静态方法中局部变量 m="+m);
        System.out.println(s1); /*为什么静态变量未加载，而且s1也未声明 数据类型，却没有报错 */
        System.out.println("父类静态方法");
    }
    static String s1 = "父类静态变量";
    public static void main(String[] args){
//        new A();
    }
}
class A extends CDemo9{
    int a = 5;
    static String s = "子类静态变量";
    {
        System.out.println("子类实例变量　a="+a);
        System.out.println("子类代码块");
    }
    static {
        System.out.println("子类静态代码块");
        method();   //测试静态方法的加载时间
    }
    A(){
        System.out.println("子类构造器");
    }
    static void method(){
        System.out.println("子类静态方法");
    }
}