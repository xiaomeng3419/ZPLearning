package com.example.Functional;

/**
 * @FunctionInterFace 的使用
 * Created by zhangpan on 2018/11/22.
 *
 * java 8 ::
 */
public class FunctionInterFace {

    public static void main(String[] args) {
        /**
         * 1、lambda表达式
         * 这种形式最为直观，lambda表达式，接收一个String类型的参数，返回一个String类型的结果。
         * 完全符合函数式接口FunctionInterfaceTest的定义
         */
        FunctionInterfaceTest functionInterfaceTest1 = item -> item + 1;
    }


    //接口一
    @FunctionalInterface
    public interface FunctionInterfaceTest {

        String getInfo(String input);

        @Override
        String toString();  //Object中的方法

        @Override
        boolean equals(Object obj); //Object中的方法
    }
}
