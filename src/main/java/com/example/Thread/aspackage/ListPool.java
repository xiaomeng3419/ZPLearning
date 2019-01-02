package com.example.Thread.aspackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangpan on 2019/1/2.
 * ���Ե�����condition.await()֮���߳��Ƿ��ͷ���
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
            list.add(new StringBuffer("����-").append(i).toString());
        }
    }


    public String get(){
        String str = null;
        try {
            concurrencySemaphore.acquire();
            lock.lock();
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

    }
}
