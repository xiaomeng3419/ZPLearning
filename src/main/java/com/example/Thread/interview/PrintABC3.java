package com.example.Thread.interview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月18日 0:49
 * @ModificationHistory:
 */
public class PrintABC3 {



    public static void main(String[] args) {
            ZPABC3 zpabc3 = new ZPABC3();
            Thread thread1 = new Thread(new ZPPrintABC3(zpabc3,'A'));
            Thread thread2 = new Thread(new ZPPrintABC3(zpabc3,'B'));
            Thread thread3 = new Thread(new ZPPrintABC3(zpabc3,'C'));
            thread1.start();
            thread2.start();
            thread3.start();


    }

}

class ZPABC3{
    public AtomicInteger total = new AtomicInteger();

    public void print(char a ){
        System.out.print(a);
        this.total.incrementAndGet();
    }

}

class ZPPrintABC3 implements Runnable{

    private ZPABC3 zpabc3;
    private static volatile int count =20;
    private char tag;
    ZPPrintABC3(ZPABC3 zpabc3,char tag){
        this.zpabc3=zpabc3;
        this.tag =  tag;

    }


    @Override
    public void run() {
        try {
            while (count>0){
                synchronized (zpabc3){
                    if(tag == 'A'){
                        if(!(zpabc3.total.get() % 3 == 0)){
                            zpabc3.wait();
                        }else {
                            zpabc3.print(tag);
                            count--;
                            zpabc3.notifyAll();
                        }
                    }
                    if(tag == 'B'){
                        if(!(zpabc3.total.get() % 3 == 1)){
                            zpabc3.wait();
                        }else {
                            zpabc3.print(tag);
                            count--;
                            zpabc3.notifyAll();
                        }
                    }
                    if(tag == 'C'){
                        if(!(zpabc3.total.get() % 3 == 2)){
                            zpabc3.wait();
                        }else {
                            zpabc3.print(tag);
                            count--;
                            zpabc3.notifyAll();
                        }
                    }


                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
