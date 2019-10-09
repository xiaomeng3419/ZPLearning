package com.example.Thread.interview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年10月03日 23:01
 * @ModificationHistory:
 */
public class PrintABC5 {



    public static void main(String[] args) {
        ZPABC5 zpabc5 = new ZPABC5();

        Thread thread1 = new Thread(new ZPPrintABC5(zpabc5,'A'));
        Thread thread2 = new Thread(new ZPPrintABC5(zpabc5,'B'));
        Thread thread3 = new Thread(new ZPPrintABC5(zpabc5,'C'));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class ZPABC5{
    public AtomicInteger total = new AtomicInteger();

    public void printABC(char tag ){
        System.out.print(tag);
        total.incrementAndGet();
    }
}

class ZPPrintABC5 implements Runnable{
    private ZPABC5 zpabc5;
    private char tag ;

    public ZPPrintABC5(ZPABC5 zpabc5, char tag) {
        this.zpabc5 = zpabc5;
        this.tag = tag;
    }

    @Override
    public void run() {
        try {
            while (zpabc5.total.get()<20){
                synchronized (zpabc5){
                    if(tag == 'A'){
                        if(zpabc5.total.get()%3==0){
                            zpabc5.printABC(tag);
                            zpabc5.notifyAll();
                        }else {
                            zpabc5.wait();
                        }
                    }
                    if(tag == 'B'){
                        if(zpabc5.total.get()%3==1){
                            zpabc5.printABC(tag);
                            zpabc5.notifyAll();
                        }else {
                            zpabc5.wait();
                        }
                    }
                    if(tag == 'C'){
                        if(zpabc5.total.get()%3==2){
                            zpabc5.printABC(tag);
                            zpabc5.notifyAll();
                        }else {
                            zpabc5.wait();
                        }
                    }

                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
