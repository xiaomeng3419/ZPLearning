package com.example.Thread.style;

/**
 * Created by zhangpan on 2018/12/9.
 */
public class Demo1  extends Thread{
    Demo1(String name){
        super(name);
    }

    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println(getName()+"this thread runing ......");
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1("demo1 ");
        Demo1 demo2  = new Demo1("demo2 ");
        demo1.setDaemon(true);//意思是随着主线程的结束而结束
//        demo2.setDaemon(true);
        demo1.start();

        demo2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo2.interrupt();
    }
}
