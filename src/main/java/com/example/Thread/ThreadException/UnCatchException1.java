package com.example.Thread.ThreadException;

import com.example.Thread.aspackage.Run;

/**
 * Created by zhangpan on 2019/1/10.
 */
public class UnCatchException1 implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("�쳣�����ˣ�");
    }
    //    @Override
//    public void uncaughtException(Thread t, Throwable e) {
//        System.out.println("�Զ����쳣��");
//    }
}
