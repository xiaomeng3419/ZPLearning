package com.example.custom;

import com.example.Thread.ThreadException.TFUFactoryA;

import java.util.LinkedHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangpan on 2019/3/31.
 */
public class CDemo6 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<Runnable>(20);
        ThreadPoolExecutor  executor = new ThreadPoolExecutor(1,
                3,20, TimeUnit.SECONDS,arrayBlockingQueue,new TFUFactoryA());
        /**
         * 线程池的6个参数，
         * 常驻线程
         * 最大线程数
         * 存活时间，
         * 时间单位
         * 阻塞队列
         * 线程工厂
         */
    }
}
