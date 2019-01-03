package com.example.Thread.aspackage;

/**
 * Created by zhangpan on 2019/1/2.
 */
public class MyThread  extends Thread{
    private ListPool listPool;

    public MyThread(ListPool listPool){
        super();
        this.listPool = listPool;
    }

    @Override
    public void run() {
//        for (int i = 0 ;i< Integer.MAX_VALUE;i++){
        for (int i = 0 ;i<100;i++){
            String getString = listPool.get();
            System.out.println(Thread.currentThread().getName()+ " È¡µÃÖµ :" + getString);
            listPool.put(getString);
        }
    }
}
