package com.example.Thread.aspackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * ���Ե�����condition.await()֮���߳��Ƿ��� Created by zhangpan on 2019/1/2.������
 * lock �� semaphore �Ķ���ͬ����������locksemaphore(1)ʱ���״̬��
 *
 * IllegalMonitorStateException ���ֵĿ��ܵļ��������
 1>��ǰ�̲߳����е�ǰ���������Դ��ʱ�򣬵���obj.wait()����;
 2>��ǰ�̲߳����е�ǰ���������Դ��ʱ�򣬵���obj.notify()������
 3>��ǰ�̲߳����е�ǰ���������Դ��ʱ�򣬵���obj.notifyAll()����
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

            list.add("����-" + (i +1));
        }
    }


    public String get(){
        String str = null;
        try {
            concurrencySemaphore.acquire();
            lock.lock();
            while (list.size() == 0){
                System.out.println("����ȴ� condition await��");
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
        System.out.println("׼������");
        condition.signalAll();
        lock.unlock();
        concurrencySemaphore.release();
    }
}
