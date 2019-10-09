package com.example.Thread.style;

import java.util.*;
/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月20日 2:17
 * @ModificationHistory:
 */
public class ThreadLocalTest {

    private static ThreadLocal<List<String>> threadLocal = new ThreadLocal<>();

    public void setThreadLocal(List<String> value) {

        threadLocal.set(value);
    }

    public void getThreadLocal() {

        threadLocal.get().forEach(s ->System.out.println(Thread.currentThread().getName()+"###" + s ));
    }


    public static void main(String[] args) {

        final ThreadLocalTest t = new ThreadLocalTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> strs = new ArrayList<String>();
                strs.add("1");
                strs.add("2");
                strs.add("3");
                System.out.println("2");
                try{
                    Thread.sleep(1000);
                }catch(Exception e){

                }
                t.setThreadLocal(strs);
                t.getThreadLocal();
            }
        },"t1").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                List<String> strs = new ArrayList<String>();
                strs.add("a");
                strs.add("b");
                t.setThreadLocal(strs);
                t.getThreadLocal();
            }
        },"t2").start();
    }

}