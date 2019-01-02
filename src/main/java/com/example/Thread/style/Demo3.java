package com.example.Thread.style;

/**
 * Created by zhangpan on 2018/12/9.
 * 只用一次使用这种
 */
public class Demo3 {
    public static void main(String[] args) {
         new Thread(){
            @Override
            public void run() {
                System.out.println(" thread start .....");
            }
        }.start();

         new Thread(new Runnable() {
             @Override
             public void run() {
                 System.out.println(" Runnable start connect  .....");
             }
         }){
             @Override
             public void run() {
                 System.out.println(" thread start connect  .....");
             }
         }.start();

    }
}
