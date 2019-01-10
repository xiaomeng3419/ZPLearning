package com.example.Thread.ThreadException;

import com.example.Thread.aspackage.Run;

/**
 * Created by zhangpan on 2019/1/10.
 */
public class TRRunnable implements Runnable {
    private  String username;
    TRRunnable(String username){
        super();
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()  + "begin " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()  + "end " + System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
