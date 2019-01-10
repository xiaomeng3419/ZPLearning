package com.example.Thread.lock.semaphore;

/**
 * Created by zhangpan on 2019/1/4.
 */
public class ThreadC extends Thread {
    private Demoq demoq;
    public  ThreadC(Demoq demoq){
        this.demoq = demoq;
    }

    @Override
    public void run() {
        demoq.setSemaphore(0);
    }
}
