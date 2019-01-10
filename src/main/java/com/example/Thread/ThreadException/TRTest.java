package com.example.Thread.ThreadException;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangpan on 2019/1/10.
 */
public class TRTest {
    public static void main(String[] args) {
        TRRunnable runnable1 = new TRRunnable("����1");
        TRRunnable runnable2 = new TRRunnable("����2");
        TRRunnable runnable3 = new TRRunnable("����3");
        TRRunnable runnable4 = new TRRunnable("����4");
        TRRunnable runnable5 = new TRRunnable("����5");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,9999L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        executor.setRejectedExecutionHandler(new TRRejectException());
        executor.execute(runnable1);
        executor.execute(runnable2);
        executor.execute(runnable3);
        executor.execute(runnable4);
        executor.execute(runnable5);
    }
}
