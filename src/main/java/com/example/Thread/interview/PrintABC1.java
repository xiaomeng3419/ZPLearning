package com.example.Thread.interview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月16日 20:17
 * @ModificationHistory:
 */
public class PrintABC1 {
    public static void main(String[] args) {
        ZPABC1 maj = new ZPABC1();
        Thread t_a = new Thread(new ZPPrintABC1(maj , 'A'));
        Thread t_b = new Thread(new ZPPrintABC1(maj , 'B'));
        Thread t_c = new Thread(new ZPPrintABC1(maj , 'C'));
        t_a.start();
        t_b.start();
        t_c.start();
    }

}

class ZPABC1{
    public AtomicInteger total = new AtomicInteger();
    public void printMajuscule(char word){
        System.out.print(word);
        total.incrementAndGet();
    }



}

class  ZPPrintABC1 implements Runnable{
    private final ZPABC1 zpabc1;

    private char tag;
    ZPPrintABC1(ZPABC1 zpabc1 ,char tag){
        this.zpabc1 = zpabc1;
        this.tag = tag;
    }
    @Override
    public void run() {
        int count = 10;
        while (count > 0){
            synchronized (zpabc1){
                if (tag == 'A'){
                    if (zpabc1.total.get() % 3 != 0){
                        try {
                            zpabc1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        zpabc1.printMajuscule(tag);
                        count --;
                        zpabc1.notifyAll();
                    }
                }
                if (tag == 'B'){
                    if (zpabc1.total.get() % 3 != 1){
                        try {
                            zpabc1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        zpabc1.printMajuscule(tag);
                        count --;
                        zpabc1.notifyAll();
                    }
                }
                if (tag == 'C'){
                    if (zpabc1.total.get() % 3 != 2){
                        try {
                            zpabc1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        zpabc1.printMajuscule(tag);
                        count --;
                        zpabc1.notifyAll();
                    }
                }
            }
        }

    }

}
