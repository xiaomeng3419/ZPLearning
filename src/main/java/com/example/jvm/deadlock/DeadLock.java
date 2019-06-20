package com.example.jvm.deadlock;

/**
 * Created by zhangpan on 2019/3/31.
 * ����ģ��
 * ���������ĵ��ĸ���Ҫ������ �������������󱣳֣������ᣬѭ������
 *
 * ���������ķ���������˳�򣬼���ʱЧ
 */
public class DeadLock {

    //������������
    private Object oa = new Object();
    private Object ob = new Object();

    /**
     * ����һ�� ����֮�� ��ʹ�� ����oa ����2��ȥʹ�� ���� ob
     */
    public void one() {

        synchronized(oa) {
            System.out.println("������ʹ�� oa");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(ob) {
                System.out.println("������ʹ�� ob");
            }
            System.out.println("������ oa ob");
        }
    }

    /**
     * �������� ����֮�� ��ʹ�� ����ob ����2��ȥʹ�� ���� oa
     */
    public void two() {
        synchronized(ob) {
            System.out.println("������ʹ�� ob");
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(oa) {
                System.out.println("������ʹ�� oa");
            }

            System.out.println("������ ob oa");
        }
    }

    public static void main(String[] args) {
        DeadLock dead = new DeadLock();		//һ��Ҫ�����߳� ʹ�� start()���ǿ������߳�
        Thread A = new Thread(new ThreadA(dead));
        Thread B =  new Thread(new ThreadB(dead));

        //�˴������Ե��� run(),����run run�ڵĴ���Ҳ�ᱻִ�У�������˳��ִ�У������������߳��� Thread.start();�ǿ���һ�����̵߳ĺ���
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
