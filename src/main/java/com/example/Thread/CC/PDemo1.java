package com.example.Thread.CC;

import java.util.concurrent.Phaser;

/**
 * Created by zhangpan on 2019/1/6.
 */
public class PDemo1 {
    public static void main(String[] args) {
        try {
            Phaser phaser = new Phaser(3);
            PThread1 thread1 = new PThread1(phaser);
            thread1.setName("zhangpan");
            thread1.start();
            Thread.sleep(2000);
            thread1.interrupt();
            System.out.println("proccess is over ...");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
