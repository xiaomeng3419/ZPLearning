package com.example.Thread.style;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年08月18日 23:40
 * @ModificationHistory:
 */
public class Demo10 {
    public static void main(String[] args) throws Exception {
        //创建CyclicBarrier对象并设置2个公共屏障点
        final CyclicBarrier barrier = new CyclicBarrier(2);
        //创建大小为2的线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            executor.submit(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println("线程" + Thread.currentThread().getName() + "即将到达集合地点1，当前已有"
                                + barrier.getNumberWaiting() + "个已经到达，正在等候");
                        //如果没有达到公共屏障点，则该线程处于阻塞状态，如果达到公共屏障点则所有处于等待的线程都继续往下运行
                        barrier.await();

                        System.out.println("线程" + Thread.currentThread().getName() + "通过集合地点1");

                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println("线程" + Thread.currentThread().getName() + "即将到达集合地点2，当前已有"
                                + barrier.getNumberWaiting() + "个已经到达，正在等候");
                        barrier.await();

                        System.out.println("线程" + Thread.currentThread().getName() + "通过集合地点2");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        //关闭线程池
        executor.shutdown();
    }
}
