package com.example.Thread.ThreadException;

/**
 * Created by zhangpan on 2019/1/10.
 */
public class TFURunnable implements Runnable {
    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName()+" " + System.currentTimeMillis());
            Thread.sleep(4000);
            String str =  null;
//            str.indexOf(0);
            System.out.println(Thread.currentThread().getName()+" " + System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
