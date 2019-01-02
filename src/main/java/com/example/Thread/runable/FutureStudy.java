package com.example.Thread.runable;

import java.time.Instant;
import java.util.concurrent.*;

/**
 * Created by zhangpan on 2018/11/8.
 * Callable、Runnable、Future、RunnableFuture和FutureTask 深入理解
 * 1、Callable 和 Runnable 都是执行的任务的接口，区别在于Callable有返回值，而Runnable无返回值
 * 2、Future 表示异步任务返回结果的接口
 * 3、RunnableFuture 继承了Runnable， Future，表示可以带有返回值的run接口
 */
public class FutureStudy {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> runFuture = executorService.submit(new MyRunTask());
        Future<String> callFuture = executorService.submit(new MyCallTask());
        Future<?> taskFuture = executorService.submit(new MyFutureTask());
        System.out.println("任务全部提交成功，开始get 获取返回结果....... ");
        Thread.sleep(3000);

        System.out.println(runFuture.get());
        System.out.println(callFuture.get());
        System.out.println(taskFuture.get());
        executorService.shutdown();

    }

    static class MyFutureTask extends FutureTask<String> {
        MyFutureTask(){
            this(new Callable<String>(){
                @SuppressWarnings("unchecked")
                @Override
                public String call() throws Exception {
                    System.out.println(" FutureTask 线程执行完毕！~" );
                    return (String) "FutureTask 返回值！~";
                }
            });
        }

        MyFutureTask(Callable<String> callable){
            super(callable);
        }


        @Override
        protected void done() {
            System.out.println("执行回调 done方法 ");
//            super.done();
        }
    }

    static class MyCallTask implements Callable<String>{
        @Override
        public String call() throws Exception {
            System.out.println(" callable 线程执行完毕！~" );
            return "callable返回值";
        }
    }
    static class MyRunTask implements Runnable{
        @Override
        public void run() {
            System.out.println(" runnable 线程执行完毕！~, 无返回值" );
        }
    }
}
