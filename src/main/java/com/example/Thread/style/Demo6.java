package com.example.Thread.style;

import java.util.concurrent.*;

/**
 * Created by zhangpan on 2018/12/10.
 */
public class Demo6 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        ExecutorService executor2 = new ThreadPoolExecutor(1,10,0L, TimeUnit.SECONDS,null);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("fix pool running task... "+ Thread.currentThread().getName());
            }
        });
        executor.shutdown();
    }
}
