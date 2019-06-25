package com.example.Thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangpan on 2018/11/7.
 *
 * 【强制】线程池不允许使用 【强制】线程池不允许使用 Executors ExecutorsExecutors Executors ExecutorsExecutors去创建，而
 * 是通过 去创建，而是通过 去创建，而是通过 ThreadPoolExecutor ThreadPoolExecutorThreadPoolExecutor ThreadPoolExecutor ThreadPoolExecutor
 * ThreadPoolExecutor ThreadPoolExecutorThreadPoolExecutor ThreadPoolExecutor ThreadPoolExecutorThreadPoolExecutor的方式，这样 的方式，
 * 这样 的处理方式让写同学更加明确线程池运行规则，避资源耗尽风险。 说明： Executors ExecutorsExecutors Executors ExecutorsExecutors
 * 返回的线程池对象 返回的线程池对象 的弊端 如下 ：
 * 1）FixedThreadPool FixedThreadPool FixedThreadPool FixedThreadPool FixedThreadPool
 * FixedThreadPool FixedThreadPool FixedThreadPool和 SingleThread SingleThreadSingleThread SingleThread SingleThread SingleThread
 * SingleThreadPoolPool Pool: 允许的请求队列长度为 Integer.MAX_VALUE，可 能会堆积大量的请求，从而导致 OOM。
 * .2）CachedThreadPool CachedThreadPool CachedThreadPool CachedThreadPool CachedThreadPool CachedThreadPool CachedThreadPool CachedThreadPool
 * 和 ScheduledThreadPool ScheduledThreadPoolScheduledThreadPool ScheduledThreadPool ScheduledThreadPool ScheduledThreadPool
 * ScheduledThreadPool ScheduledThreadPool ScheduledThreadPool ScheduledThreadPool : 允许的创建线程数量为 Integer.MAX_VALUE，
 * 可能会创建大量的线程，从而导致 OOM
 *
 * https://www.cnblogs.com/zedosu/p/6665306.html
 */
public class CustomThreadPoolExecutor {
    private ThreadPoolExecutor poolExecutor = null;
    /**
     * 线程池初始化方法
     *
     * corePoolSize 核心线程池大小----10
     * maximumPoolSize 最大线程池大小----30
     * keepAliveTime 线程池中超过corePoolSize数目的空闲线程最大存活时间----30+单位TimeUnit
     * TimeUnit keepAliveTime时间单位----TimeUnit.MINUTES
     * workQueue 阻塞队列----new ArrayBlockingQueue<Runnable>(10)====10容量的阻塞队列
     * threadFactory 新建线程工厂----new CustomThreadFactory()====定制的线程工厂
     * rejectedExecutionHandler 当提交任务数超过maxmumPoolSize+workQueue之和时,
     * 							即当提交第41个任务时(前面线程都没有执行完,此测试方法中用sleep(100)),
     * 						          任务会交给RejectedExecutionHandler来处理
     */
    public void init(){

        poolExecutor = new ThreadPoolExecutor(10,
                30,
                30,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(10),
                new CustomThreadFactory(),
                new CustomRejectExecutionHandler());
    }


    public void destory(){
        if (poolExecutor != null){
           poolExecutor.shutdownNow();
        }
    }

    public ExecutorService getCustomThreadPoolExecutor(){
        return this.poolExecutor;
    }


    /***
     * 线程池工厂方法
     */
    private class CustomThreadFactory implements ThreadFactory{
        private AtomicInteger atomicCount =  new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            String threadName = CustomThreadPoolExecutor.class.getSimpleName()+atomicCount.addAndGet(1);
            System.out.println(threadName);
            thread.setName(threadName);
            return thread;
        }
    }

    private class  CustomRejectExecutionHandler implements RejectedExecutionHandler{
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            //记录异常
            //报警处理等等
            System.out.println("****************************线程异常 r***************************");
        }
    }

    public static void main(String[] args)throws Exception {
       CustomThreadPoolExecutor exec = new CustomThreadPoolExecutor();
       exec.init();
       ExecutorService pool = exec.getCustomThreadPoolExecutor();
       for (int i = 0 ; i < 100;i++){
           System.out.println("第"+i+"个任务。。。。。");
/*
           pool.execute(new Runnable() {
               @Override
               public void run() {
                   try {
                       Thread.sleep(30000);
                   }catch (Exception e){
                       e.printStackTrace();
                   }
                   System.out.println("running =========");
               }
           });
*/
            Future<?> s = pool.submit(new MyCallTask());
//            Future<?> s = pool.submit(new MyRunableFuture());
           System.out.println(s.get());
//          pool.execute(new MyRunableFuture());
       }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class  MyRunableFuture  implements RunnableFuture<String>{
        @Override
        public void run() {
           try {
//               Thread.sleep(10);
           }catch (Exception e){
               e.printStackTrace();
           }
            System.out.println("myrunableFuture task runing");
        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }

        @Override
        public boolean isCancelled() {
            return false;
        }

        @Override
        public boolean isDone() {
            return false;
        }

        @Override
        public String get() throws InterruptedException, ExecutionException {
            return "runable Future called value";
        }

        @Override
        public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return null;
        }
    }
    static class MyCallTask implements Callable<String>{
        @Override
        public String call() throws Exception {
            System.out.println(" callable 线程执行完毕！~" );
            return "callable返回值";
        }
    }
}
