package com.example.Thread.CC;

import java.util.concurrent.Phaser;

/**
 * Created by zhangpan on 2019/1/6.
 * awaitAdvance(0)如果getPhaser()==0 则是，等待，如果不等的话就继续向下执行
 */
public class PThread1 extends Thread {

    private Phaser phaser ;
    public PThread1(Phaser phaser){
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +"A1 begin ="+System.currentTimeMillis());
        System.out.println(phaser.getPhase());
        phaser.awaitAdvance(1);
        System.out.println(Thread.currentThread().getName() +"A1 end ="+System.currentTimeMillis());
    }
}
