package com.example.Thread.interview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月24日 10:50
 * @ModificationHistory:
 */
public class PrintABC4 {

    public static void main(String[] args) {
        ZPABC4 zpabc4 = new ZPABC4();
        Thread thread1 = new Thread(new ZPPrintABC4(zpabc4,'A'));
        Thread thread2 = new Thread(new ZPPrintABC4(zpabc4,'B'));
        Thread thread3 = new Thread(new ZPPrintABC4(zpabc4,'C'));
        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class  ZPABC4{
     public  AtomicInteger total = new AtomicInteger();

     public void printChar(char tag){
         System.out.print(tag);
         total.incrementAndGet();
     }
}

class  ZPPrintABC4 implements Runnable{
    private static  ZPABC4 zpabc4 ;
    private char tag;
    ZPPrintABC4(ZPABC4 zpabc4,char tag){
        this.tag = tag;
        this.zpabc4 =zpabc4;

    }

    @Override
    public void run() {
        try {
            while (zpabc4.total.get()<10){
                synchronized (zpabc4){
                    if (tag == 'A'){
                        if(!(zpabc4.total.get()%3 == 0)){
                            zpabc4.wait();
                        }else {
                            zpabc4.printChar(tag);
                            zpabc4.notifyAll();
                        }
                    }
                    if (tag == 'B'){
                        if(!(zpabc4.total.get()%3 == 1)){
                            zpabc4.wait();
                        }else {
                            zpabc4.printChar(tag);
                            zpabc4.notifyAll();
                        }
                    }
                    if (tag == 'C'){
                        if(!(zpabc4.total.get()%3 == 2)){
                            zpabc4.wait();
                        }else {
                            zpabc4.printChar(tag);
                            zpabc4.notifyAll();
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}