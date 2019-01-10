package com.example.Thread.ThreadException;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by zhangpan on 2019/1/10.
 */
public class TRRejectException implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(executor.getThreadFactory().toString()+" ,threadName:"+Thread.currentThread().getName()+"username:"+((TRRunnable)r).getUsername()+"任务过多拒绝！");
    }
}
