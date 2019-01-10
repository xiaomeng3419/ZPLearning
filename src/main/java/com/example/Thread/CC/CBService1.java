package com.example.Thread.CC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by zhangpan on 2019/1/6.
 */
public class CBService1 {
    public CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
        @Override
        public void run() {
            System.out.println("彻底结束了。。。"+System.currentTimeMillis());
        }
    });

    public void testMethod(){
        try {
            System.out.println(Thread.currentThread().getName() +"准备"+System.currentTimeMillis());
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName()+"结束！"+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (BrokenBarrierException e){
            e.printStackTrace();
        }
    }

}
