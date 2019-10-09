package com.example.collection.queue;

import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年08月22日 0:25
 * @ModificationHistory:
 */
public class ZPQueue<T> {
    private  int size;
    private ZPNODE<T> start;
    private ZPNODE<T> end;
    private int length;

    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    public ZPQueue(){

    }

    public ZPQueue (int length){
        this.length = length;
        size = 0;
        this.start = this.end = null;
    }
    public void push(T item){
        lock.lock();
        try {
            if (size == length) {
                System.out.println("队列满");
                full.await();
            }
            ZPNODE<T> node = new ZPNODE<>(item);
            if (end == null){
                start = end = node;
            }else {
                end.next = new ZPNODE<>(item);
                end = end.next;
            }
            size++;
            empty.signal();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常了");
        } finally {
            lock.unlock();
        }
    }

    public T pop(){
        lock.lock();
        try {
            if (size == 0){
                System.out.println("队列空");
                empty.await();
            }
            T result = start.getItem();
            start = start.next;
            full.signal();
            size--;
            return  result;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("异常了");
        }finally {
            lock.unlock();
        }
        return null;
    }
    public static void main(String[] args) throws InterruptedException {
        ZPQueue<Integer> blockQueue = new ZPQueue<Integer>(3);
        blockQueue.push(1);
        System.out.println(blockQueue.pop());
        blockQueue.push(2);
        System.out.println(blockQueue.pop());
        blockQueue.push(3);
        System.out.println(blockQueue.pop());

        blockQueue.push(5);
        blockQueue.push(5);
        System.out.println(blockQueue.pop());
        Thread thread  = new Thread();
        thread.start();
    }

    @Data
    private class ZPNODE<T>{
        private T item;
        private ZPNODE<T> next;
        public ZPNODE(T item){this.next = null;this.item = item;}
    }
}
