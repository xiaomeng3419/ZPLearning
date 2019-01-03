package com.example.Thread.aspackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 测试的是在condition.await()之后线程是否释 Created by zhangpan on 2019/1/2.放锁，
 * lock 和 semaphore 的都是同步器，而且locksemaphore(1)时候的状态，
 *
 * IllegalMonitorStateException 出现的可能的几种情况：
 1>当前线程不含有当前对象的锁资源的时候，调用obj.wait()方法;
 2>当前线程不含有当前对象的锁资源的时候，调用obj.notify()方法。
 3>当前线程不含有当前对象的锁资源的时候，调用obj.notifyAll()方法
 *
 */
public class ListPool {
    private  int  poolMaxSieze = 3;
    private int semaphorePermits = 5;
    private List<String> list = new ArrayList<>();
    private Semaphore concurrencySemaphore = new Semaphore(semaphorePermits);
    private ReentrantLock lock  = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public ListPool(){
        super();
        for (int i = 0;i< poolMaxSieze;i++){

            list.add("张攀-" + (i +1));
        }
    }


    public String get(){
        String str = null;
        try {
            concurrencySemaphore.acquire();
            lock.lock();
            while (list.size() == 0){
                System.out.println("进入等待 condition await！");
                condition.await();
            }
            str = list.remove(0);


        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return str;
    }


    public void put(String stringValue){
        lock.lock();
        list.add(stringValue);
        System.out.println("准备唤醒");
        condition.signalAll();
        lock.unlock();
        concurrencySemaphore.release();
    }
}
