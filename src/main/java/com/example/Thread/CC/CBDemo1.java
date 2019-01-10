package com.example.Thread.CC;

/**
 * Created by zhangpan on 2019/1/6.
 * 说明reset之后它的许可重新置位0 ，并不会中断父线程的运行
 */
public class CBDemo1 {
    public static void main(String[] args)throws InterruptedException {
        CBService1 service1 = new CBService1();
        CBThread1 cbThread1 = new CBThread1(service1);
        cbThread1.setName("A");
        cbThread1.start();
        Thread.sleep(2000);
        service1.cyclicBarrier.reset();
        CBThread2 cbThread2 = new CBThread2(service1);
        cbThread2.setName("B");
        CBThread1 cbThread3 = new CBThread1(service1);
        cbThread3.setName("C");
        cbThread2.start();
        cbThread3.start();
    }
}
