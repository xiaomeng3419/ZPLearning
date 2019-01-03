package com.example.Thread.aspackage;

/**
 * Created by zhangpan on 2019/1/2.
 */
public class Run {

    public static void main(String[] args) {
        ListPool listPool = new ListPool();
        MyThread[] myThreads = new  MyThread[12];
        for (int i = 0 ; i <myThreads.length;i++){
            myThreads[i] = new MyThread(listPool);
        }
        for (int i = 0;i<myThreads.length;i++){
            myThreads[i].start();
        }
    }
}
