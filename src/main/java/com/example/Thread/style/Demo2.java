package com.example.Thread.style;

/**
 * Created by zhangpan on 2018/12/9.
 * 作为线程任务存在
 */
public class Demo2 implements Runnable {
    @Override
    public void run() {
     while (true){
         System.out.println("runnable runing ....");
     }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Demo2());
        thread.start();
    }
}
