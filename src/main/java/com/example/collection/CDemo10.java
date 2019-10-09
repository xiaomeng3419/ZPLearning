package com.example.collection;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年08月13日 17:12
 * @ModificationHistory:
 */
public class CDemo10 {
    //非静态初始化块能初始化静态变量,也可以初始化实例变量。（顺序问题但是前提是得通过实例化来调用构造方法）
    //静态初始化块可以初始化静态变量，但是不能初始化实例变量。和静态初始化块的加载时间有关。

    static int i,j;
    int k=0;
    //非静态初始化
    {
        System.out.println("输出结果");
        i=5;
        System.out.println(i);
        k=6;//内存中还没有这个k变量，非静态变量依赖于对象存在
        System.out.println(k);
    }

    //静态初始化块
    static{
        j=6;
//		k=0;
        System.out.println("静态代码块");
    }


    public static void main(String[] args) {
        System.out.println(i);
        System.out.println(j);
        CDemo10 cDemo10 = new CDemo10();
//11    初始化块初始化静态变量 AA=new 初始化块初始化静态变量();

    }

}
