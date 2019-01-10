package com.example.Thread.lock.semaphore;

/**
 * Created by zhangpan on 2019/1/4.
 */
public class ThreadP  extends Thread{
    private Demoq demoq;
    public ThreadP(Demoq demoq){
        this.demoq = demoq;
    }

    @Override
    public void run() {
        demoq.setSemaphore(1);
    }
}
