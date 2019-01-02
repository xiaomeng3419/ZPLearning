package com.example.Thread.aspackage;

/**
 * Created by zhangpan on 2019/1/2.
 */
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition ���Lock  ʵ���̵߳ĵȴ� ��֪ͨ
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
                    lock.lock();//������
                    try{
                        System.out.println(Thread.currentThread().getName()+"==������ȴ�");
                        condition.await();//���õ�ǰ�߳̽���ȴ�
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally{
                        System.out.println(Thread.currentThread().getName()+"==���ͷ���");
                        lock.unlock();//�ͷ���
                    }
                    System.out.println(Thread.currentThread().getName()+"==������ִ��");
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
                    lock.lock();//������
                    try{
                        System.out.println(Thread.currentThread().getName()+"=������");
                        Thread.sleep(2000);//��Ϣ2��
                        condition.signal();//������ѵȴ������е�һ���߳�
                        System.out.println(Thread.currentThread().getName()+"��Ϣ����");
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally{
                        System.out.println(Thread.currentThread().getName()+"==���ͷ���");
                        lock.unlock();//�ͷ���
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
