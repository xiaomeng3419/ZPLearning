package com.example.Thread.lock.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangpan on 2019/1/4.
 * ���Թ��� semaphore��acquire��release֮��lock����ĸ���
 * ����� semaphore��ɸ�����ʹ���õúܴ����������lock��lock��unlock����ֻ������һ���߳������С�
 * ����ʵ�飺lock.semphore���е�Demoq,run ,ThreadP,ThreadC��4��java�ļ�
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

}
