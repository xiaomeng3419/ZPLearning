package com.example.Thread.lock.semaphore;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangpan on 2019/1/4.
 * 测试关于 semaphore的acquire和release之间lock允许的个数
 * 结果： semaphore许可个数即使设置得很大，如果其中有lock，lock和unlock部分只允许有一个线程在其中。
 * 本次实验：lock.semphore包中的Demoq,run ,ThreadP,ThreadC这4个java文件
 *
 */
public class Demoq {
    volatile private Semaphore semaphore  = new Semaphore(2);

    volatile private ReentrantLock lock = new ReentrantLock();


    public void setSemaphore(int ks){
        try {
            semaphore.acquire();
            lock.lock();
            System.out.println("lock enter....");
            if(ks == 0){
                Thread.sleep(1000);
            }
            System.out.println("this thread is :"+ Thread.currentThread().getName()+ ks);
            System.out.println("lock out....");


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    LinkedBlockingDeque

    public void

}
