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
            System.out.println("���׽����ˡ�����"+System.currentTimeMillis());
        }
    });

    public void testMethod(){
        try {
            System.out.println(Thread.currentThread().getName() +"׼��"+System.currentTimeMillis());
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName()+"������"+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (BrokenBarrierException e){
            e.printStackTrace();
        }
    }

}
