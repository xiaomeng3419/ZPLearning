package com.example.Thread.aspackage;

/**
 * Created by zhangpan on 2019/1/2.
 */
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition 配合Lock  实现线程的等待 与通知
 */
public class ConditionTest{
    public static ReentrantLock lock=new ReentrantLock();
    private static Semaphore semaphore = new Semaphore(1);
    public static Condition condition =lock.newCondition();
    public static void main(String[] args) throws Exception{
        new Thread(){
            @Override
            public void run() {
                try {
                    semaphore.acquire(1);
                    lock.lock();//请求锁
                    try{
                        System.out.println(Thread.currentThread().getName()+"==》进入等待");
                        condition.await();//设置当前线程进入等待
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally{
                        System.out.println(Thread.currentThread().getName()+"==》释放锁");
                        lock.unlock();//释放锁
                    }
                    System.out.println(Thread.currentThread().getName()+"==》继续执行");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    semaphore.release(1);
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    semaphore.acquire(1);
                    lock.lock();//请求锁
                    try{
                        System.out.println(Thread.currentThread().getName()+"=》进入");
                        Thread.sleep(2000);//休息2秒
                        condition.signal();//随机唤醒等待队列中的一个线程
                        System.out.println(Thread.currentThread().getName()+"休息结束");
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally{
                        System.out.println(Thread.currentThread().getName()+"==》释放锁");
                        lock.unlock();//释放锁
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    semaphore.release(1);
                }
            }
        }.start();
    }
}
