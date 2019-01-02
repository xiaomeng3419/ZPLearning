package com.example.Thread.style;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by zhangpan on 2018/12/26.
 * ������ǵ����������ִ��
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
                System.out.println("No."+ seq +"�˿����ڼ����");
                if(seq %2 == 0){
                    Thread.sleep(10000);
                    System.out.println("No."+ seq +"�˿���ݿ��ɣ�");
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (BrokenBarrierException e){
                e.printStackTrace();
            }finally {
//                semaphore.release();
                System.out.println("No."+ seq +"�˿���ɼ�飡");
                System.out.println("ͨ��barrier.getNumberWaiting()��ȡ���ڵȴ����߳�����"+cyclicBarrier.getNumberWaiting());
                System.out.println("ͨ��barrier.getNumberWaiting()��ȡ���ڵȴ����߳���getParties��"+cyclicBarrier.getParties());
            }
        }
    }
}
