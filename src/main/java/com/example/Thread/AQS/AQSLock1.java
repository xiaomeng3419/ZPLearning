package com.example.Thread.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by zhangpan on 2019/1/11.
 */
public class AQSLock1  implements Lock{
    private  Helper helper = new Helper();
    @Override
    public void lock() {
        helper.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
            helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1,unit.toNanos(time ));
    }

    @Override
    public void unlock() {
        helper.release(1);
    }

    @Override
    public Condition newCondition() {
        return helper.newCondition();
    }

    private class Helper extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            /**
             * 1、如果第一个线程进来，直接拿到锁
             * 2、如果第二个进程进来，返回false,若当前线程和进来的线程是同一个，则可以拿到，需要更新状态值
             * 3、判断第一个线程进来还是其他线程进来
             */
            int state = getState();
            Thread t  = Thread.currentThread();
            if(state == 0){
                if(compareAndSetState(0,arg)){
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }else {
                if(getExclusiveOwnerThread() == t){
                    setState(state+1);
                    return true;
                }
            }

            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(Thread.currentThread() != getExclusiveOwnerThread()){
                throw new RuntimeException();
            }
            int state = getState() -arg;
            boolean flag = false;
            if(getState() == 0){
                setExclusiveOwnerThread(null);
                flag = true;
            }
            setState(state);
            return flag ;
        }

        Condition newCondition(){
            return new ConditionObject();
        }
    }
}
