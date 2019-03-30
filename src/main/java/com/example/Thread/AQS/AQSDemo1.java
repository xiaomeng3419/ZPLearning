package com.example.Thread.AQS;

import java.util.concurrent.*;

/**
 * Created by zhangpan on 2019/1/11.
 */
public class AQSDemo1 {
    private  int value;
    private AQSLock1 lock1 = new AQSLock1();
    public int next(){
        lock1.lock();
        try {
            Thread.sleep(300);
            return value++;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            lock1.unlock();
        }

    }
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Executor executor = Executors.newSingleThreadScheduledExecutor();
        ThreadPoolExecutor x = new ThreadPoolExecutor(1,2,5L, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
        AQSDemo1 demo1 = new AQSDemo1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start.....");
                demo1.a();
                System.out.println("end.....");
//                while (true){
//                    System.out.println(Thread.currentThread().getId()+":"+demo1.next());
//                }
            }
        }).start();



    }

    public void a(){
        lock1.lock();
        System.out.println("a");
        b();
        lock1.unlock();
    }
    public void b(){
        lock1.lock();
        System.out.println("b");

        lock1.unlock();
    }
}
