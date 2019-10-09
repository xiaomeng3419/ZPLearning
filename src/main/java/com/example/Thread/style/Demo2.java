package com.example.Thread.style;

/**
 * Created by zhangpan on 2018/12/9.
 * ��Ϊ�߳��������
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
//        thread.threadLocals.
    }
}
