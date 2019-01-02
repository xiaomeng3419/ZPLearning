package com.example.Thread.style;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by zhangpan on 2018/12/9.
 */
public class Demo4 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception  {
        System.out.println("���ڽ��е����εļ���....");
        Thread.sleep(3000);
        return 1;
    }

    public static void main(String[] args) throws Exception{
        Demo4  demo4  = new Demo4();
        FutureTask<Integer>  task = new FutureTask<Integer>(demo4);
        Thread thread = new Thread(task);

        thread.start();
        System.out.println("���ȸɱ�� ....");
        System.out.println("result : + "+ task.get());
    }
}
