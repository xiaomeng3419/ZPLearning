package com.example.Thread.style;

import java.util.concurrent.Semaphore;

/**
 * Created by zhangpan on 2018/12/26.
 */
public class Demo8 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 5 ;i++ ){
            new SecurityCheckThread(i,semaphore).start();
        }
    }

    private static  class SecurityCheckThread extends Thread{
        private int seq;
        private Semaphore semaphore;
        SecurityCheckThread(int seq,Semaphore semaphore){
            this.seq = seq;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("No."+ seq +"乘客正在检查中");
                if(seq %2 == 0){
                    Thread.sleep(10000);
                    System.out.println("No."+ seq +"乘客身份可疑！");
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                semaphore.release();
                System.out.println("No."+ seq +"乘客完成检查！");
            }
        }
    }
}
