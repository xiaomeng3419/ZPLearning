package com.example.Thread.interview;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月17日 23:04
 * @ModificationHistory:
 */
public class PrintABC2 {
    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor  = new ThreadPoolExecutor(1,2,2, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(20));
        ZPABC2 zpabc2 = new ZPABC2();
        Thread thread1 = new Thread(new ZPPrintABC2('A',zpabc2) );
        Thread thread2 = new Thread(new ZPPrintABC2('B',zpabc2) );
        Thread thread3 = new Thread(new ZPPrintABC2('C',zpabc2) );
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class ZPABC2{
    public AtomicInteger total = new AtomicInteger();

    public void printABC2(char tag){
        System.out.print(tag);
        total.incrementAndGet();
    }
}

class ZPPrintABC2 implements Runnable{
    private ZPABC2 zpabc2;
    private char tag;

    private volatile int count = 10 ;
    ZPPrintABC2(char tag,ZPABC2 zpabc2){
        this.tag = tag;
        this.zpabc2 = zpabc2;
    }


    @Override
    public void run() {
        try {

            while (count-->0){
                synchronized (zpabc2){
                   if(tag == 'A'){
                       if(!(zpabc2.total.get()%3==0)){
                           zpabc2.wait();
                       }else {
                           zpabc2.printABC2(tag);
                           zpabc2.notifyAll();
                       }
                   }
                   if(tag == 'B'){
                       if(!(zpabc2.total.get()%3==1)){
                           zpabc2.wait();
                       }else {
                           zpabc2.printABC2(tag);
                           zpabc2.notifyAll();
                       }
                   }

                   if(tag== 'C'){
                       if(!(zpabc2.total.get()%3==2)){
                           zpabc2.wait();
                       }else {
                           zpabc2.printABC2(tag);
                           zpabc2.notifyAll();
                       }
                   }

                }


            }
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }
}