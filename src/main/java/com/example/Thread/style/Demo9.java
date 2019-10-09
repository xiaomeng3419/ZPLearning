package com.example.Thread.style;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by zhangpan on 2018/12/26.
 * 意义就是到了这个点再执行
 */
public class Demo9 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        for (int i = 1;i<= 5; i++){
          new TextSecurityCheckThread(i,cyclicBarrier).start();
        }
        /**
         new Thread(() -> {

         }).start();
         */

    }



    private static  class TextSecurityCheckThread extends Thread{
        private int seq;
        private CyclicBarrier cyclicBarrier;
        TextSecurityCheckThread(int seq,CyclicBarrier cyclicBarrier){
            this.seq = seq;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                System.out.println("No."+ seq +"乘客正在检查中");
                if(seq %2 == 0){
                    Thread.sleep(10000);
                    System.out.println("No."+ seq +"乘客身份可疑！");
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (BrokenBarrierException e){
                e.printStackTrace();
            }finally {
//                semaphore.release();
                System.out.println("No."+ seq +"乘客完成检查！");
                System.out.println("通过barrier.getNumberWaiting()获取正在等待的线程数："+cyclicBarrier.getNumberWaiting());
                System.out.println("通过barrier.getNumberWaiting()获取正在等待的线程数getParties："+cyclicBarrier.getParties());
            }
        }
    }
}
