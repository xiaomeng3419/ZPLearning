package com.example.Thread.CC;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhangpan on 2019/1/6.
 */
public class CLThread1 extends  Thread {

    private CountDownLatch countDownLatch;

    public CLThread1 (CountDownLatch countDownLatch){
        super();
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("pre"+Thread.currentThread().getName());
            Thread.sleep(2000);
            /**
             * 源码中的sync就是线程同步器
             */

            countDownLatch.countDown();
            System.out.println("after"+Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
