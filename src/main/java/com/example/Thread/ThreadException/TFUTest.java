package com.example.Thread.ThreadException;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangpan on 2019/1/10.
 */
public class TFUTest {

    public static void main(String[] args) {
        TFURunnable runnable  = new TFURunnable();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,9999,9999L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(),new TFUFactoryA());
        executor.execute(runnable);

    }
}
