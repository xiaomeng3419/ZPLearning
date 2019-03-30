package com.example.Thread.interview;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;
/**
 * Created by zhangpan on 2019/3/13.
 */
public class OrderPrint {
    volatile  static  int flag = 1;
    volatile static  int num =0;
    static void print(int n){
        num=n;
        ExecutorService executor= Executors.newFixedThreadPool(4);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (;num>0;){
                    if (flag==1) {
                        System.out.print("A");
                        flag = 2;
                    }
                }

            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (;num>0;){
                    if(flag==2) {
                        System.out.print("B");
                        flag = 3;
                    }
                }

            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (;num>0;){
                    if(flag==3) {
                        System.out.print("C");
                        flag = 4;

                    }
                }

            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (;num>0;){
                    if(flag==4) {
                        System.out.print("D");
                        num=num-1;
                        flag = 1;
                    }
                }

            }
        });
        for (;num>0;){
            executor.shutdownNow();
        }
    }

    public static void main(String[] args) {
      print(10);
    }


}
