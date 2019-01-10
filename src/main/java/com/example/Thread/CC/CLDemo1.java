package com.example.Thread.CC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangpan on 2019/1/6.
 * 此demo验证的await 需要是countdownlatch之后释放被唤醒，如果注释CountDownLatch.await(),则就是立即执行success语句，
 */
public class CLDemo1  {
    public static void main(String[] args)throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        CLThread1[] thread1s = new CLThread1[Integer.parseInt(""+countDownLatch.getCount())];
        for (int i = 0 ; i < thread1s.length;i++){
            thread1s[i]= new CLThread1(countDownLatch);
            thread1s[i].setName("线程"+i);
            thread1s[i].start();
        }
        countDownLatch.await();
        System.out.println("success");

        ThreadPoolExecutor executor = new ThreadPoolExecutor(7,8,5, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
        executor.shutdownNow();
    }
}
