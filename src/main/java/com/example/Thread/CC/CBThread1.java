package com.example.Thread.CC;

/**
 * Created by zhangpan on 2019/1/6.
 */
public class CBThread1 extends Thread {
    private CBService1 service;
    public CBThread1(CBService1 service){
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
