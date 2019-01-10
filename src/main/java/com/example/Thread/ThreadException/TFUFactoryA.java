package com.example.Thread.ThreadException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.ThreadFactory;

/**
 * Created by zhangpan on 2019/1/10.
 */
public class TFUFactoryA implements ThreadFactory {
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        }
    };
    public Thread newThread(Runnable runnable){
        Instant now = Instant.now();
        Thread thread = new Thread(runnable);
        thread.setUncaughtExceptionHandler(new UnCatchException1());
        thread.setName("’≈≈  £∫ "+df.get().format(Date.from(now)) );
        return thread;
    }
}
