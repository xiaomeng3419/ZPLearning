package com.example.jvm.deadlock;

/**
 * Created by zhangpan on 2019/3/31.
 * 死锁模拟
 * 死锁产生的的四个必要条件： 互斥条件，请求保持，不剥夺，循环依赖
 *
 * 避免死锁的方法：加锁顺序，加锁时效
 */
public class DeadLock {

    //定义两个对象
    private Object oa = new Object();
    private Object ob = new Object();

    /**
     * 方法一： 运行之后 先使用 对象oa 休眠2秒去使用 对象 ob
     */
    public void one() {

        synchronized(oa) {
            System.out.println("我正在使用 oa");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(ob) {
                System.out.println("我正在使用 ob");
            }
            System.out.println("我用了 oa ob");
        }
    }

    /**
     * 方法二： 运行之后 先使用 对象ob 休眠2秒去使用 对象 oa
     */
    public void two() {
        synchronized(ob) {
            System.out.println("我正在使用 ob");
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(oa) {
                System.out.println("我正在使用 oa");
            }

            System.out.println("我用了 ob oa");
        }
    }

    public static void main(String[] args) {
        DeadLock dead = new DeadLock();		//一定要定义线程 使用 start()才是开启多线程
        Thread A = new Thread(new ThreadA(dead));
        Thread B =  new Thread(new ThreadB(dead));

        //此处不可以调用 run(),调用run run内的代码也会被执行，程序是顺序执行，不会启动多线程跑 Thread.start();是开启一个新线程的函数
        A.start();
        //A.run();
        System.out.println("---a");
        B.start();
        //B.run();
        System.out.println("b---");
    }


    private static class ThreadA implements Runnable{//extends Thread{
        private DeadLock da;
        public ThreadA(DeadLock da) {
            super();
            this.da = da;
        }
        @Override
        public void run() {
            da.one();
        }
    }
    private static class ThreadB implements Runnable{//extends Thread{
        private DeadLock db;
        public ThreadB(DeadLock db) {
            super();
            this.db = db;
        }
        @Override
        public void run() {
            db.two();
        }
    }
}
