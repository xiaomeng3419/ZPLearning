package com.example.Thread.style;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年08月18日 23:43
 * @ModificationHistory:
 */
public class Demo11 {
    public static void main(String[] args) {
        //该计数器初始值1，用于主线程发送命令
        final CountDownLatch latch1 = new CountDownLatch(1);
        //该计数器初始值为2，用于响应命令接受完成
        final CountDownLatch latch2 = new CountDownLatch(2);
        //创建一个大小为2线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            executor.submit(new Runnable() {
                public void run() {
                    try {
                        System.out.println("线程" + Thread.currentThread().getName() + "正准备接受命令");
                        //等待主线程发送命令
                        latch1.await();
                        System.out.println("线程" + Thread.currentThread().getName() + "已接受命令");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("线程" + Thread.currentThread().getName() + "回应命令处理结果");
                        //命令接受完毕，返回给主线程，latch2减1。
                        latch2.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        try {
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("线程" + Thread.currentThread().getName() + "即将发布命令");
            //发送命令，latch1计数减1
            latch1.countDown();
            System.out.println("线程" + Thread.currentThread().getName() + "已发送命令，正在等待响应");
            //命令发送后处于等待状态，其它线程全部响应完成，也就是latch2.countDown()，再继续执行
            latch2.await();
            System.out.println("线程" + Thread.currentThread().getName() + "已收到所有响应结果");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //关闭线程池
        executor.shutdown();
    }
}
